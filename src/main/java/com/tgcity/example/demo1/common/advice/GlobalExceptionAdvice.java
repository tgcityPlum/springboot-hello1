package com.tgcity.example.demo1.common.advice;


import com.tgcity.example.demo1.common.exception.BizException;
import com.tgcity.example.demo1.common.exception.TipException;
import com.tgcity.example.demo1.common.model.response.BaseResponse;
import com.tgcity.example.demo1.common.model.response.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常拦截，主要拦截验证信息
 *
 * @author xietong
 */
@Slf4j
@RestControllerAdvice
@Order(2020)
public class GlobalExceptionAdvice {

    /**
     * 参数校验失败异常
     */
    @ExceptionHandler(BindException.class)
    public BaseResponse handleBindException(BindException e) {
        return buildErrorResponse(e.getBindingResult());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse handleBindException(MethodArgumentNotValidException e) {
        return buildErrorResponse(e.getBindingResult());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse handleConstraintViolation(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.stream().findFirst().get();
        return BaseResponse.msg(violation.getMessage()).build();
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResponse handleHttpMethodException(HttpRequestMethodNotSupportedException e) {
        String msg = String.format("不支持 [%s] 请求", e.getMethod());
        return BaseResponse.code(400).msg(msg).build();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResponse handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        String msg = String.format("缺少 %s 参数", e.getParameterName());
        return BaseResponse.code(400).msg(msg).build();
    }

    @ExceptionHandler(BizException.class)
    public BaseResponse<Void> handleBizException(BizException e) {
        log.error("业务异常", e);
        return BaseResponse.code(e.getCode()).msg(e.getMessage()).build();
    }

    @ExceptionHandler(TipException.class)
    public BaseResponse handleTipException(TipException e) {
        log.error("业务异常", e);
        return BaseResponse.code(e.getStatus()).msg(e.getMessage()).build();
    }

    /**
     * 全局异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse handleException(Exception e) {
        //todo  暂时对外提供Message.SYSTEM_ERROR这个异常
        log.error(e.getMessage(), e);
        return BaseResponse.buildSuccess(Message.SYSTEM_ERROR).build();
    }

    private BaseResponse<Void> buildErrorResponse(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        String collect = fieldErrors.stream().map(fieldError -> fieldError.getField() + "：" + fieldError.getDefaultMessage())
                .collect(Collectors.joining("；"));
        return BaseResponse.code(400).msg(collect).build();
    }

}
