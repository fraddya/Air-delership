package com.finalproject.delership.domain;

import com.finalproject.delership.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Plane extends CreateModifyAwareBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    private Integer numberOfPassenger;
    private String model;
    private String price;
    private Integer age;
    private Float flyDistance;
    private String fuelConsumption;
    private Integer fuelTankCapacity;
    private String height;
    private String length;
    private String width;
    private Status status;
}
