package datasource;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.Physical;
import common.Position;
import common.SourceStatus;
import common.SourceType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @file Sensor.java
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

@JsonTypeName("Sensor")
public class Sensor extends DataSource {
    public Sensor() {
    }


    public Sensor(int source_id, SourceType type, SourceStatus status, Position position, Map<String, Physical> metrics, List<Map<String, String>> topics) {
        super(source_id, type, status, position, metrics, topics);
    }


    @Override
    public String toString() {
        return "Sensor{" +
                "source_id=" + source_id +
                ", type=" + type +
                ", status=" + status +
                ", position=" + position +
                ", metrics=" + metrics +
                ", topics=" + topics +
                '}';
    }


    @Override
    public String executeCommand(int commandFunction, long commandParam) {
        switch (commandFunction) {
            case 1:
                return "Sensor:" + this.getSource_id() + " 正在暂停...";
            case 2:
                return "Sensor:" + this.getSource_id() + " 正在恢复...";
            case 3:
                return "Sensor:" + this.getSource_id() + " 正在从某个指定时间点重新启动任务...";
            case 4:
                return "Sensor:" + this.getSource_id() + " 重置采集长度...";
            case 5:
                startup();
                return "Sensor:" + this.getSource_id() + " 正在开机...";
            case 6:
                shutdown();
                return "Sensor:" + this.getSource_id() + " 正在关机...";
            default:
                return "Sensor:" + this.getSource_id() + " 不支持该操作";
        }
    }
}

