package common;

/**
 * @file SourceStatus.java
 * @comment 数据源的状态
 * @date 2025/4/23
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public enum SourceStatus {
    S_OFFLINE,          //离线
    S_IDLE,             //空闲
    S_ENGAGED,          //占用
    S_ABNORMAL          //异常
}
