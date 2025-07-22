package database;

import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.Dcts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TargetDBWriter {

    private static final String INSERT_SQL = "INSERT INTO target (" +
            "id, time_seconds, time_nanos, name, camp, air_space, equ_type, " +
            "latitude, longitude, altitude, yaw, pitch, roll, " +
            "east_velocity, north_velocity, vertical_velocity) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static void batchInsertTargets(Connection conn, List<Aeronaval.Target> targets) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            for (Aeronaval.Target target : targets) {
                ps.setLong(1, target.getId());
                ps.setLong(2, target.getTime().getSeconds());
                ps.setInt(3, target.getTime().getNanos());
                ps.setString(4, target.getName());
                ps.setInt(5, target.getCamp().getNumber());
                ps.setInt(6, target.getAirSpace().getNumber());
                ps.setInt(7, target.getEquType().getNumber());

                Dcts.Position position = target.getPosition();
                ps.setDouble(8, position.getLatitude());
                ps.setDouble(9, position.getLongitude());
                ps.setDouble(10, position.getAltitude());

                Dcts.Posture posture = target.getPosture();
                ps.setDouble(11, posture.getYaw());
                ps.setDouble(12, posture.getPitch());
                ps.setDouble(13, posture.getRoll());

                Aeronaval.Velocity velocity = target.getVelocity();
                ps.setDouble(14, velocity.getEastVelocity());
                ps.setDouble(15, velocity.getNorthVelocity());
                ps.setDouble(16, velocity.getVerticalVelocity());

                ps.addBatch(); // 添加批次
            }
            ps.executeBatch(); // 执行批量插入
        }
    }
}
