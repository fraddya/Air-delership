package com.finalproject.delership.domain.converter;

import com.finalproject.delership.enums.FuelConsumption;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FuelConsumptionConverter implements AttributeConverter<FuelConsumption, String> {

    @Override
    public String convertToDatabaseColumn(FuelConsumption attribute) {
        return attribute != null ? attribute.getValue() : null;
    }

    @Override
    public FuelConsumption convertToEntityAttribute(String dbData) {
        return dbData != null ? FuelConsumption.getEnum(dbData) : null;
    }
}
