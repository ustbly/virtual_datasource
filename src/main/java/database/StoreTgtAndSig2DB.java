package database;

import org.zeromq.ZMQ;
import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.fusion.airDomain.target.TargetOuterClass;
import zb.dcts.scenario.detection.Detection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class StoreTgtAndSig2DB {
    private static final String SUB_ADDR = "tcp://localhost:5560";
    private static final String JDBC_URL = "jdbc:mysql://node1:9030/kgd?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "123456";

    public static void main(String[] args) {
        ZMQ.Context context = ZMQ.context(10);
        ZMQ.Socket subscriber = context.socket(ZMQ.SUB);
        subscriber.connect(SUB_ADDR);
        subscriber.subscribe("Fusion_AirDomain".getBytes());

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS)) {
            System.out.println("Connected to Doris successfully.");
            // 创建入库控制器（建议 batchSize: 50~200，根据实际 TPS 决定）
            BufferWriteController bufferWriter = new BufferWriteController(conn, 50);

            while (!Thread.currentThread().isInterrupted()) {
                subscriber.recv();
                byte[] msgBytes = subscriber.recv();

                try {
                    TargetOuterClass.FusionTargetList fusionTargetList = TargetOuterClass.FusionTargetList.parseFrom(msgBytes);

                    // 加入 Target 缓冲
                    Aeronaval.Target aeronavalTarget = fusionTargetList.getAeronavalTarget();
                    bufferWriter.addTarget(aeronavalTarget);

                    List<Detection.SignalLayerSurvey> signalLayerSurveysList = fusionTargetList.getSignalLayerSurveysList();
//                    System.out.println(signalLayerSurveysList);

                    // 加入 Survey 缓冲
                    for (Detection.SignalLayerSurvey survey : signalLayerSurveysList) {
                        bufferWriter.addSurvey(survey);
                    }
                } catch (Exception e) {
                    System.err.println("Failed to parse CombinedMessage");
                    e.printStackTrace();
                }
                // 程序结束或退出前调用
                Runtime.getRuntime().addShutdownHook(new Thread(bufferWriter::shutdown));
            }
        } catch (SQLException e) {
            System.err.println("Doris connection failed.");
            e.printStackTrace();
        }
    }
}
