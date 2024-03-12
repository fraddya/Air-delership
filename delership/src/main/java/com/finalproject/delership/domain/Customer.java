package com.finalproject.delership.domain;

import com.finalproject.delership.domain.base.CreateModifyAwareBaseEntity;
import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Customer extends CreateModifyAwareBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String firstName;
    private String lastName;
    private String contactNo;
    private Integer age;
    private GenderType genderType;
    private String nic;
    private String email;
    private String country;
    private Status status;

    @OneToMany(mappedBy = "customer")
    private Set<ContactPerson> contactPeople;
}
