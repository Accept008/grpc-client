package com.example.lab.exception;

import cn.soundbus.library.core.exception.annotation.ExceptionResponseInfo;
import cn.soundbus.library.core.exception.general.GeneralException;
import org.springframework.http.HttpStatus;

/**
 * 自定义400异常
 * 语义有误、参数有误相关
 *
*/

@ExceptionResponseInfo(
    status = HttpStatus.BAD_REQUEST,
    errCode = BadException.CODE,
    errMsg = "Incorrect semantics or request parameters",
    devMsg = "Equivalent to HTTP 400 Bad Request error",
    moreInfoUrl = "https://tools.ietf.org/html/rfc7235#section-3.1"
)

public class BadException extends GeneralException {
    public static final String CODE = "E400";

    public BadException() {
        this((String)null);
    }

    public BadException(String message) {
        super(CODE, message);
    }

}
