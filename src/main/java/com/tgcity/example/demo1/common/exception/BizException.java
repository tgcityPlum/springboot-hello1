package com.tgcity.example.demo1.common.exception;

import com.tgcity.example.demo1.common.model.response.Message;
import lombok.Getter;

/**
 * @author: TGCity
 * @create: 2020/5/28
 * @description 通用业务异常
 */
@Getter
public class BizException extends RuntimeException {

    private final int code;

    public BizException(Message message) {
        super(message.getMessage());
        code = message.getCode();
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(Message message, Throwable cause) {
        super(message.getMessage(), cause);
        code = message.getCode();
    }
}
