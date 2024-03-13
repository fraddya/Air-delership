package com.finalproject.delership.domain.converter;

import com.finalproject.delership.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status != null ? status.getValue() : null;
    }

    @Override
    public Status convertToEntityAttribute(String s) {
        return s != null ? Status.getEnum(s) : null;
    }

}
