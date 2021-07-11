package com.example.lab.exception;

import cn.soundbus.library.core.exception.annotation.ExceptionResponseInfo;
import cn.soundbus.library.core.exception.general.GeneralException;
import org.springframework.http.HttpStatus;

/**
 * 自定义403异常
 *
 *
*/

@ExceptionResponseInfo(
    status = HttpStatus.FORBIDDEN,
    errCode = ForbiddenException.CODE,
    errMsg = "Equivalent to HTTP 403 Forbidden Request error",
    devMsg = "Equivalent to HTTP 403 Forbidden Request error",
    moreInfoUrl = "https://tools.ietf.org/html/rfc7235#section-3.1"
)

public class ForbiddenException extends GeneralException {
    public static final String CODE = "E400";

    public ForbiddenException() {
        this((String)null);
    }

    public ForbiddenException(String message) {
        super(CODE, message);
    }

}
