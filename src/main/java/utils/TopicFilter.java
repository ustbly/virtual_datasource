package utils;

import java.util.Map;

// 订阅请求中的 Topic 对象，支持单个键值对过滤
public class TopicFilter {
    private String key;   // 如 signal_type, encoding, etc.
    private String value; // 如 QAM, AES-256

    public TopicFilter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public boolean matches(Map<String, String> signalMeta) {
        return signalMeta.containsKey(key) && value.equals(signalMeta.get(key));
    }
}
