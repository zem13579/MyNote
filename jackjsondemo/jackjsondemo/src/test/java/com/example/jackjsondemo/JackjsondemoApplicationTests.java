package com.example.jackjsondemo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


class JackjsondemoApplicationTests {


    // 自定义 BigDecimal 序列化器
    static class CustomBigDecimalSerializer extends JsonSerializer<BigDecimal> {
        @Override
        public void serialize(BigDecimal value, com.fasterxml.jackson.core.JsonGenerator gen, SerializerProvider serializers) throws java.io.IOException {
            if (value == null) {
                gen.writeString("---");
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                gen.writeString(decimalFormat.format(value));
            }
        }
    }

    // 自定义 Integer 序列化器
    static class CustomIntegerSerializer extends JsonSerializer<Integer> {
        @Override
        public void serialize(Integer value, com.fasterxml.jackson.core.JsonGenerator gen, SerializerProvider serializers) throws java.io.IOException {
            if (value == null) {
                gen.writeString("--");
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("#,##0");
                gen.writeString(decimalFormat.format(value));
            }
        }
    }

    // 自定义 Date 序列化器
    static class CustomDateSerializer extends JsonSerializer<Date> {
        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        @Override
        public void serialize(Date value, com.fasterxml.jackson.core.JsonGenerator gen, SerializerProvider serializers) throws java.io.IOException {
            if (value == null) {
                gen.writeString("--");
            } else {
                gen.writeString(dateFormat.format(value));
            }
        }
    }

    @Data
    @AllArgsConstructor
    static class CustomPojo {
        @JsonSerialize(using = CustomBigDecimalSerializer.class, nullsUsing = CustomBigDecimalSerializer.class)
        private BigDecimal bigDecimal;

        @JsonSerialize(using = CustomIntegerSerializer.class, nullsUsing = CustomIntegerSerializer.class)
        private Integer integer;

        @JsonSerialize(using = CustomDateSerializer.class, nullsUsing = CustomDateSerializer.class)
        private Date date;
    }

    @Test
    void contextLoads() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        // 测试数据，部分字段为空
        BigDecimal bigDecimal = null;
        Integer integer = 123;
        Date date = null;

        CustomPojo pojo = new CustomPojo(new BigDecimal("1231232334.954444"), 1234567899, new Date());

        // 序列化
        String pojoJson = mapper.writeValueAsString(pojo);
        System.out.println(pojoJson);
    }

}
