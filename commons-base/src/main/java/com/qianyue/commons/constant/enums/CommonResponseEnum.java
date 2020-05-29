package com.qianyue.commons.constant.enums;

import com.qianyue.commons.exception.assertion.CommonExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>通用返回结果</p>
 *
 * @author sprainkle
 * @date 2019/5/2
 */
@Getter
@AllArgsConstructor
public enum CommonResponseEnum implements CommonExceptionAssert {
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 服务器繁忙，请稍后重试
     */
    SERVER_BUSY(9998, "服务器繁忙"),
    /**
     * 服务器异常，无法识别的异常，尽可能对通过判断减少未定义异常抛出
     */
    SERVER_ERROR(9999, "网络异常"),

    /**
     * 5***，一般对应于系统封装的工具出现异常
     */
    JSON_FORMAT_ERROR(6001, "序列化异常"),
    JSON_PARSE_ERROR(6002, "反序列化异常"),

    // Time
    DATE_NOT_NULL(5001, "日期不能为空"),
    DATETIME_NOT_NULL(5001, "时间不能为空"),
    TIME_NOT_NULL(5001, "时间不能为空"),
    DATE_PATTERN_MISMATCH(5002, "日期[%s]与格式[%s]不匹配，无法解析"),
    PATTERN_NOT_NULL(5003, "日期格式不能为空"),
    PATTERN_INVALID(5003, "日期格式[%s]无法识别"),
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
}