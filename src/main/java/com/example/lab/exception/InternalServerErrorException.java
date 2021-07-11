package com.example.lab.exception;

import cn.soundbus.library.core.exception.annotation.ExceptionResponseInfo;
import cn.soundbus.library.core.exception.general.GeneralException;
import org.springframework.http.HttpStatus;

/**
 * 自定义500异常: 服务端错误
 *
 */
@ExceptionResponseInfo(
        status = HttpStatus.INTERNAL_SERVER_ERROR,
        errCode = BadException.CODE,
        errMsg = "Internal Server Error",
        devMsg = "Equivalent to HTTP 500 Internal Server Error",
        moreInfoUrl = "https://tools.ietf.org/html/rfc7235#section-3.1"
)
public class InternalServerErrorException extends GeneralException {
    public static final String CODE = "E500";

    public InternalServerErrorException() {
        this((String)null);
    }

    public InternalServerErrorException(String message) {
        super(CODE, message);
    }
}
