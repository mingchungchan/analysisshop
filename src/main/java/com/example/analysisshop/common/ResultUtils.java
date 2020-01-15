package com.example.analysisshop.common;

public class ResultUtils {

    public static Result succeed() {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("SUCCEED");
        return result;
    }

    public static Result succeed(Object o) {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("SUCCEED");
        result.setData(o);
        return result;
    }


    public static Result failed(String code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result failed() {
        Result result = new Result();
        result.setCode("100");
        result.setMsg("FAILED");
        return result;
    }
}
