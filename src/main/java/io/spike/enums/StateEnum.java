package io.spike.enums;

public enum StateEnum {

    SUCCESS(1, "request success"),

    FAIL(2, "request fail"),

    ;

    private Integer code;

    private String msg;

    StateEnum(Integer state, String msg) {
        this.code = state;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static StateEnum stateOf(Integer index) {
        for (StateEnum stateEnum : values()) {
            if (index.equals(stateEnum.getCode())) {
                return stateEnum;
            }
        }
        return null;
    }
}
