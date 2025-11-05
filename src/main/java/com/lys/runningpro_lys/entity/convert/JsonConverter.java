package com.lys.runningpro_lys.entity.convert;

// Routes 엔티티에 선언된 routeData를 위한 convert 클래스
//  JSON으로 변환하기 위한 convert 클래스

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
// 엔티티 필드 Object, DB 칼럼 타입 String
public class JsonConverter implements AttributeConverter<Object, String>{

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        try{
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e){
            throw new IllegalArgumentException("JSON 변환 실패: " + e.getMessage());
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try{
            return objectMapper.readValue(dbData, Object.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
