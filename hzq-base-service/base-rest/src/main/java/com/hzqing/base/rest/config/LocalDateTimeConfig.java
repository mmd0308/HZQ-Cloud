package com.hzqing.base.rest.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 传入或传出数据，
 * 如果是时间类型，根据要求格式化
 * @author hzqing
 * @date 2019-08-11 12:12
 */
@Configuration
public class LocalDateTimeConfig {
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
    }

    @Bean
    public LocalDateTimeDeserializer localDateTimeDeserializer() {
        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
    }


    @Bean
    public LocalDateSerializer localDateSerializer(){
        return new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    @Bean
    public LocalDateDeserializer localDateDeserializer() {
        return new LocalDateDeserializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    @Bean
    public LocalTimeSerializer localTimeSerializer(){
        return new LocalTimeSerializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT));
    }

    @Bean
    public LocalTimeDeserializer localTimeDeserializer() {
        return new LocalTimeDeserializer(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT));
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> builder
                .serializerByType(LocalDateTime.class, localDateTimeSerializer())
                .serializerByType(LocalTime.class,localTimeSerializer())
                .serializerByType(LocalDate.class,localDateSerializer())
                .deserializerByType(LocalDateTime.class,localDateTimeDeserializer())
                .deserializerByType(LocalTime.class,localTimeDeserializer())
                .deserializerByType(LocalDate.class,localDateDeserializer());
    }

}
