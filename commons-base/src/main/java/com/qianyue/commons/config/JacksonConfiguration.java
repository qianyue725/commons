package com.qianyue.commons.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.qianyue.commons.constant.CommonConstants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 * 描述:
 *
 * @auther qianyue
 * @date 2020/5/23 1:00
 */
public class JacksonConfiguration {

    private JacksonConfiguration() {}

    private volatile static ObjectMapper objectMapper;

    public static ObjectMapper getInstance() {

        if (objectMapper == null) {
            synchronized (JacksonConfiguration.class) {
                if(objectMapper == null) {
                    objectMapper = new ObjectMapper();
                    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
                    JavaTimeModule javaTimeModule = new JavaTimeModule();
                    DateTimeFormatter formatter = DateTimeFormatter.
                            ofPattern(CommonConstants.TIME_PATTERN, Locale.getDefault());
                    javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
                    javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(formatter));
                    javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(formatter));
                    javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));
                    javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(formatter));
                    javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(formatter));
                    objectMapper.registerModule(javaTimeModule);
                }
            }
        }
        return objectMapper;
    }

}
