package common;

public enum Type {
    TEMPERATURE(1),
    HUMIDITY(2),
    ANGLE(3),
    DISTANCE(4),
    VELOCITY(5),
    ANGULAR_VELOCITY(6),
    VOTAGE(7),
    POWER(8),
    CURRENT(9);

    private final int value;

    Type(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }

    // 从整数转换
    public static Type fromValue(int value) {
        for (Type type:Type.values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw  new IllegalArgumentException("无效的类型：" + value);
    }
}
