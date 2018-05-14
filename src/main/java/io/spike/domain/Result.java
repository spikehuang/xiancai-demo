package io.spike.domain;

import io.spike.enums.StateEnum;

public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Result(StateEnum stateEnum, T data) {
        this.code = stateEnum.getCode();
        this.msg = stateEnum.getMsg();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
