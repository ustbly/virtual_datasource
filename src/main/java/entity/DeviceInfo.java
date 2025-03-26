package entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import common.Physical;
import common.Position;
import common.Posture;
import datasource.InfoSystem;
import datasource.Sensor;

import java.util.List;

public class DeviceInfo {
    private String type;
    private String status;
    private Position position;
    private Posture Posture;
    private List<Physical> physical;

    public DeviceInfo(String type, String status, Position position, Posture posture, List<Physical> physical) {
        this.type = type;
        this.status = status;
        this.position = position;
        this.Posture = posture;
        this.physical = physical;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public common.Posture getPosture() {
        return Posture;
    }

    public void setPosture(common.Posture posture) {
        Posture = posture;
    }

    public List<Physical> getPhysical() {
        return physical;
    }

    public void setPhysical(List<Physical> physical) {
        this.physical = physical;
    }

    public DeviceInfo() {
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", position=" + position +
                ", Posture=" + Posture +
                ", physical=" + physical +
                '}';
    }
}

