package database;

import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.scenario.detection.Detection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @file BufferWriteController.java
 * @comment 用于批量写入 Target 和 SignalLayerSurvey 数据到数据库。
 *          通过线程安全的缓存队列和定时任务实现自动批量入库。
 * @date 2025/7/11
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class BufferWriteController {
    // 批次大小
    private final int batchSize;
    // 数据库连接对象
    private final Connection connection;
    // 线程安全队列
    private final BlockingQueue<Aeronaval.Target> targetQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<Detection.SignalLayerSurvey> surveyQueue = new LinkedBlockingQueue<>();
    // 定时任务调度器
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public BufferWriteController(Connection conn, int batchSize) {
        this.connection = conn;
        this.batchSize = batchSize;
        startAutoFlush();  // 启动定时任务
    }

    public void addTarget(Aeronaval.Target target) {
        // offer 返回值忽略：队列为无界，永不丢失
        targetQueue.offer(target);
        if (targetQueue.size() >= batchSize) {
            flushTargets();
        }
    }

    public void addSurvey(Detection.SignalLayerSurvey survey) {
        surveyQueue.offer(survey);
        if (surveyQueue.size() >= batchSize) {
            flushSurveys();
        }
    }

    public void flushAll() {
        flushTargets();
        flushSurveys();
    }

    private void flushTargets() {
        List<Aeronaval.Target> batch = new ArrayList<>();
        targetQueue.drainTo(batch, batchSize);
        if (!batch.isEmpty()) {
            try {
                TargetDBWriter.batchInsertTargets(connection, batch);
                System.out.println("[写入] Target 批量入库: " + batch.size() + " 条");
            } catch (SQLException e) {
                System.err.println("[错误] Target 批量写入失败: " + e.getMessage());
            }
        }
    }

    private void flushSurveys() {
        List<Detection.SignalLayerSurvey> batch = new ArrayList<>();
        surveyQueue.drainTo(batch, batchSize);
        if (!batch.isEmpty()) {
            try {
                SignalLayerSurveyDBWriter.batchInsertSurveys(connection, batch);
                System.out.println("[写入] SignalLayerSurvey 批量入库: " + batch.size() + " 条");
            } catch (SQLException e) {
                System.err.println("[错误] Survey 批量写入失败: " + e.getMessage());
            }
        }
    }

    private void startAutoFlush() {
        scheduler.scheduleAtFixedRate(this::flushAll, 10, 5, TimeUnit.SECONDS);
    }

    public void shutdown() {
        scheduler.shutdownNow();
        flushAll();
    }
}