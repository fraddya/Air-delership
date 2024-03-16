package com.finalproject.delership.domain.converter;

import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.PlaneFlyDistance;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PlaneFlyDistanceConverter implements AttributeConverter<PlaneFlyDistance, String> {

    @Override
    public String convertToDatabaseColumn(PlaneFlyDistance attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public PlaneFlyDistance convertToEntityAttribute(String dbData) {
        return dbData != null ? PlaneFlyDistance.getEnum(dbData) : null;
    }
}
