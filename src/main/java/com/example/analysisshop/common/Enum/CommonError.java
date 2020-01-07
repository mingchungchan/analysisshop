package com.example.analysisshop.common.Enum;

public enum CommonError {
    SUCCEED("200", "SUCCEED"),
    FAILED("100", "FAILED"),
    OBJECT_IS_NULL("2001", "对象为空"),

    ;


    private String code;
    private String msg;

    CommonError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
