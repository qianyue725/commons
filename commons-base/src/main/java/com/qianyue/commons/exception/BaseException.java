package com.qianyue.commons.exception;

import com.qianyue.commons.constant.BaseEnum;
import lombok.Getter;

/**
 * 描述:
 *
 * @auther qianyue
 * @date 2020/5/22 23:56
 */
@Getter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private BaseEnum baseEnum;

    public BaseException(BaseEnum baseEnum) {
        super(baseEnum.getMessage());
        this.baseEnum = baseEnum;
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.baseEnum = new BaseEnum() {
            @Override
            public int getCode() {
                return code;
            }

            @Override
            public String getMessage() {
                return msg;
            }
        };
    }

    public BaseException(BaseEnum baseEnum, String message) {
        super(message);
        this.baseEnum = baseEnum;
    }

    public BaseException(BaseEnum baseEnum, String message, Throwable cause) {
        super(message, cause);
        this.baseEnum = baseEnum;
    }
}
