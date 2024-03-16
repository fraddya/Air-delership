package com.finalproject.delership.dto.response.plane;

import com.finalproject.delership.enums.*;
import lombok.Data;

@Data
public class PlaneSearchResponse {

    private Long id;

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
