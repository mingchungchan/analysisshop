package com.example.analysisshop.common;

import com.example.analysisshop.common.exception.ServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerHandler {


    /**
     * 业务异常
     * @param req
     * @param e
     */
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Result serviceException(HttpServletRequest req, ServiceException e){
        return ResultUtils.failed(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 其他异常
     * @param req
     * @param e
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result allException(HttpServletRequest req, Exception e){
        return ResultUtils.failed();
    }


}
