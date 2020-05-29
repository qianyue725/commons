package com.qianyue.commons.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qianyue.commons.config.JacksonConfiguration;
import com.qianyue.commons.constant.enums.CommonResponseEnum;

import java.util.Objects;

/**
 * 描述:
 *
 * @auther qianyue
 * @date 2020/5/23 9:27
 */
public class JsonUtils {

    public static String toJson(Object obj) {
        Objects.requireNonNull(obj);
        String result = "";
        try {
            result = JacksonConfiguration.getInstance().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            CommonResponseEnum.JSON_FORMAT_ERROR.assertFail(e);
        }
        return result;
    }

    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        T object = null;
        try {
            object = JacksonConfiguration.getInstance().readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            CommonResponseEnum.JSON_PARSE_ERROR.assertFail(e);
        }
        return object;
    }

}
