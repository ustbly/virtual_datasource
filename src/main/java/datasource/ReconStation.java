package datasource;

import com.fasterxml.jackson.annotation.JsonTypeName;
import common.Physical;
import common.Position;
import common.SourceStatus;
import common.SourceType;

import java.util.List;
import java.util.Map;

/**
 * @file ReconStation.java
 * @date 2025/4/21
 * @comment 侦察站类型的数据源
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

@JsonTypeName("ReconStation")
public class ReconStation extends DataSource {

    public ReconStation() {
    }

    public ReconStation(int source_id, SourceType type, int capability, SourceStatus status, Position position, Map<String, Physical> metrics, List<Map<String, String>> topics) {
        super(source_id, type, capability, status, position, metrics, topics);
    }

    @Override
    public String toString() {
        return "ReconStation{" +
                "source_id=" + source_id +
                ", type=" + type +
                ", capability=" + capability +
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
                return "ReconStation:" + this.getSource_id() + " 正在暂停...";
            case 2:
                return "ReconStation:" + this.getSource_id() + " 正在恢复...";
            case 3:
                return "ReconStation:" + this.getSource_id() + " 正在从某个指定时间点重新启动任务...";
            case 4:
                return "ReconStation:" + this.getSource_id() + " 重置采集长度...";
            case 5:
                startup();
                return "ReconStation:" + this.getSource_id() + " 正在开机...";
            case 6:
                shutdown();
                return "ReconStation:" + this.getSource_id() + " 正在关机...";
            default:
                return "ReconStation:" + this.getSource_id() + " 不支持该操作";
        }
    }
}

