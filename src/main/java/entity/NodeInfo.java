package entity;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import datasource.DataSource;
import datasource.InfoSystem;
import datasource.ReconStation;
import datasource.Sensor;

import java.sql.Timestamp;
import java.util.List;



public class NodeInfo {
    private String node_id;                     // 节点编号
    private String node_name;                   // 节点名称
    private String node_type;                   // 节点数据源类型（Sensor/ReconStation/InfoSystem）
    private String last_heard;               // 上次获取节点信息的时间
    private List<DataSource> dataSourceList;    // 节点包含的设备列表
    private boolean is_physical;                // 物理设备/虚拟设备

    public NodeInfo() {
    }

    public NodeInfo(String node_id, String node_name, String node_type, String last_heard, List<DataSource> dataSourceList, boolean is_physical) {
        this.node_id = node_id;
        this.node_name = node_name;
        this.node_type = node_type;
        this.last_heard = last_heard;
        this.dataSourceList = dataSourceList;
        this.is_physical = is_physical;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public String getNode_type() {
        return node_type;
    }

    public void setNode_type(String node_type) {
        this.node_type = node_type;
    }

    public String getLast_heard() {
        return last_heard;
    }

    public void setLast_heard(String last_heard) {
        this.last_heard = last_heard;
    }

    public List<DataSource> getDataSourceList() {
        return dataSourceList;
    }

    public void setDataSourceList(List<DataSource> dataSourceList) {
        this.dataSourceList = dataSourceList;
    }

    public boolean getIs_physical() {
        return is_physical;
    }

    public void setIs_physical(boolean is_physical) {
        this.is_physical = is_physical;
    }

    @Override
    public String toString() {
        return "NodeInfo{" +
                "node_id='" + node_id + '\'' +
                ", node_name='" + node_name + '\'' +
                ", node_type='" + node_type + '\'' +
                ", last_heard=" + last_heard +
                ", dataSourceList=" + dataSourceList +
                ", is_physical=" + is_physical +
                '}';
    }
}
