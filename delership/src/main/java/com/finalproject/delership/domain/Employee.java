package com.finalproject.delership.domain;

import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Employee extends CreateModifyAwareBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String firstName;
    private String lastName;
    private String contactNo;
    private String dateJoin;
    private Integer age;
    private GenderType genderType;
    private String nic;
    private String nationality;
    private String image;
    private String religion;
    private String email;
    private String userLogging;
    private Status status;
}
