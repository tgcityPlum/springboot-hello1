package com.tgcity.example.demo1.common.exception;

import com.tgcity.example.demo1.common.model.response.Message;
import lombok.Getter;

/**
 * 仅用于提示的异常，该异常不会导致输出堆栈
 *
 * @author xietong
 */
@Getter
public class TipException extends RuntimeException {
    /**
     * 响应状态码
     */
    private final int status;

    public TipException(Message message) {
        super(message.getMessage());
        this.status = message.getCode();
    }

    public TipException(int status, String msg) {
        super(msg);
        this.status = status;
    }
}
