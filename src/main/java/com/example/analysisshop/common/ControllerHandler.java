package com.example.analysisshop.common;

import com.example.analysisshop.common.exception.ServiceException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 异常全局处理
 */
@ControllerAdvice
public class ControllerHandler {


    /**
     * 业务异常
     */
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public Result serviceException(ServiceException e){
        return ResultUtils.failed(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 统一数据验证异常，使用@Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException exception) {
        List<FieldError> allErrors = exception.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError errorMessage : allErrors) {
            sb.append(errorMessage.getField()).append(": ").append(errorMessage.getDefaultMessage()).append(", ");
        }
        System.out.println(sb.toString());
        return ResultUtils.failed("100",sb.toString());
    }

    //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return ResultUtils.failed("100",message);
    }

    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return ResultUtils.failed("100",message);
    }

    /**
     * 其他异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result allException(HttpServletRequest req, Exception e){
        return ResultUtils.failed();
    }

}
