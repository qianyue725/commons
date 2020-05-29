package com.qianyue.commons.exception.assertion;

import com.qianyue.commons.constant.BaseEnum;
import com.qianyue.commons.exception.BaseException;

import java.text.MessageFormat;

/**
 * <pre>
 *
 * </pre>
 *
 * @author sprainkle
 * @date 2019/5/2
 */
public interface CommonExceptionAssert extends BaseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BaseException(this, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BaseException(this, msg, t);
    }

}