package com.finalproject.delership.domain.converter;

import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.PlaneSpeed;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PlaneSpeedConverter implements AttributeConverter<PlaneSpeed, String> {

    @Override
    public String convertToDatabaseColumn(PlaneSpeed attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public PlaneSpeed convertToEntityAttribute(String dbData) {
        return dbData != null ? PlaneSpeed.getEnum(dbData) : null;
    }
}
