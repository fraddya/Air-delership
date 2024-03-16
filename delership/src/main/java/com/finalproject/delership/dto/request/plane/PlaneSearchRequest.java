package com.finalproject.delership.dto.request.plane;

import com.finalproject.delership.domain.base.BaseSearchRequest;
import com.finalproject.delership.enums.*;
import lombok.Data;

@Data
public class PlaneSearchRequest extends BaseSearchRequest {

    private String name;
    private Integer sheet;//numberOfPassenger
    private String image;
    private String price;
    private Integer old;//plane age
    private Float weight;
    private FuelConsumption fuel;
    private PlaneSpeed speed;
    private PlaneFlyDistance range;
    private PlaneType primary;
    private Status status;

    private String sortProperty = "lastModifiedAt";

    @Override
    public String getSortProperty() {
        return sortProperty;
    }
}
