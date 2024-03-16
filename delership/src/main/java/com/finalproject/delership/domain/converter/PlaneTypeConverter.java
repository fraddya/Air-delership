package com.finalproject.delership.domain.converter;

import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.PlaneType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PlaneTypeConverter implements AttributeConverter<PlaneType, String> {

    @Override
    public String convertToDatabaseColumn(PlaneType attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public PlaneType convertToEntityAttribute(String dbData) {
        return dbData != null ? PlaneType.getEnum(dbData) : null;
    }
}
