package com.tgcity.example.demo1.common.model.response;

import lombok.Getter;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.io.Serializable;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 统一的响应格式
 */
@Getter
public class BaseResponse<T> implements Serializable {

    /**
     * 状态码
     */
    private int status;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 数据模型
     */
    private T data;

    public BaseResponse(int code, String message, T data) {
        this.status = code;
        this.msg = message;
        this.data = data;
    }

    /**
     * 创建一个状态信息为Message.OK的builder
     *
     * @return builder
     */
    public static ResponseBuilder ok(){
        return buildSuccess(Message.OK);
    }

    /**
     * 以一种较短的方式创建一个状态信息为Message.OK的响应，用于get方法较多
     *
     * @return BaseResponse
     */
    public static <T> BaseResponse<T> ok(T data){
        return ok().data(data);
    }

    /**
     * 创建一个状态码为status的builder
     *
     * @param code 响应状态码
     * @return builder
     */
    public static ResponseBuilder code(int code){
        return new ResponseBuilder().code(code);
    }

    /**
     * 创建提示信息为msg的builder
     *
     * @param msg 对外提供提示信息
     * @return builder
     */
    public static ResponseBuilder msg(String msg){
        return new ResponseBuilder().msg(msg);
    }

    /**
     * 创建一个带有响应状态、提示信息的builder
     *
     * @param message 响应状态码以及提示信息的枚举
     * @return builder
     */
    public static ResponseBuilder buildSuccess(Message message){
        Assert.notNull(message,"message must not null");
        return new ResponseBuilder().message(message);
    }

    /**
     * 创建一个带有响应状态、提示信息以及具体响应信息的BaseResponse
     *
     * @param message 响应状态码以及提示信息的枚举
     * @param data    具体的响应信息
     * @param <T>     与具体的响应信息一致的类
     * @return BaseResponse
     */
    public static <T> BaseResponse<T> buildSuccess(Message message,T data){
        return buildSuccess(message).data(data);
    }

    public static class ResponseBuilder {
        private int code;
        private String message;

        public ResponseBuilder message(Message message) {
            this.code = message.code;
            this.message = message.message;
            return this;
        }

        public ResponseBuilder code(int code) {
            this.code = code;
            return this;
        }

        public ResponseBuilder msg(String message) {
            this.message = message;
            return this;
        }

        public <T> BaseResponse<T> data(@Nullable T data) {
            return new BaseResponse<T>(code, message, data);
        }

        public <T> BaseResponse<T> build() {
            return data(null);
        }
    }
}
