package com.finalproject.delership.dto.request.plane;

import com.finalproject.delership.enums.*;
import lombok.Data;

@Data
public class PlaneCreateRequest {

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
}
