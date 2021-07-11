package com.example.lab.exception;

import cn.soundbus.library.core.exception.annotation.ExceptionResponseInfo;
import cn.soundbus.library.core.exception.general.GeneralException;
import org.springframework.http.HttpStatus;

/**
 * 自定义401异常
 *
 */
// formatter:off
@ExceptionResponseInfo(
        status = HttpStatus.UNAUTHORIZED,
        errCode = UnauthorizedException.CODE,
        errMsg = "Unauthorized, you must login first.",
        devMsg = "Equivalent to HTTP 401 Unauthorized error, indicates that the request has not been applied because it lacks valid authentication credentials for the target resource.",
        moreInfoUrl = "https://tools.ietf.org/html/rfc7235#section-3.1"
)
// formatter:on
public class UnauthorizedException extends GeneralException {

    public static final String CODE = "E401";

    public UnauthorizedException(String message) {
        super(CODE, message);
    }

    public UnauthorizedException() {
        this(null);
    }
}
