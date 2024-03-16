package com.finalproject.delership.domain;

import com.finalproject.delership.domain.base.CreateModifyAwareBaseEntity;
import com.finalproject.delership.enums.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Plane extends CreateModifyAwareBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private Integer sheet;//numberOfPassenger
    private String image;
    private String price;
    private Integer old;//plane age
    private Float weight;
    private FuelConsumption fuel;
    private PlaneSpeed speed;
    @Column(name = "`range`")
    private PlaneFlyDistance range;
    @Column(name = "`primary`")
    private PlaneType primary;


    //private Float flyDistance;
    //private String fuelConsumption;
    //private Integer fuelTankCapacity;
    //private String height;
    //private String length;
    //private String width;
    //private String model;
    private Status status;
}
