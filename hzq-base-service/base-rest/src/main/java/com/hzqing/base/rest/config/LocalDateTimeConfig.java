package com.cnpc.admin.config;

import com.cnpc.common.constant.CommonConstant;
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
 * 返回数据格式化
 * @author hzqing
 * @date 2018/11/22 07:55
 */
@Configuration
public class LocalDateTimeConfig {

    @Bean
    public LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(CommonConstant.DEFAULT_DATE_TIME_FORMAT));
    }

    @Bean
    public LocalDateTimeDeserializer localDateTimeDeserializer() {
        return new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(CommonConstant.DEFAULT_DATE_TIME_FORMAT));
    }


    @Bean
    public LocalDateSerializer localDateSerializer(){
        return new LocalDateSerializer(DateTimeFormatter.ofPattern(CommonConstant.DEFAULT_DATE_FORMAT));
    }

    @Bean
    public LocalDateDeserializer localDateDeserializer() {
        return new LocalDateDeserializer(DateTimeFormatter.ofPattern(CommonConstant.DEFAULT_DATE_FORMAT));
    }

    @Bean
    public LocalTimeSerializer localTimeSerializer(){
        return new LocalTimeSerializer(DateTimeFormatter.ofPattern(CommonConstant.DEFAULT_TIME_FORMAT));
    }

    @Bean
    public LocalTimeDeserializer localTimeDeserializer() {
        return new LocalTimeDeserializer(DateTimeFormatter.ofPattern(CommonConstant.DEFAULT_TIME_FORMAT));
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
