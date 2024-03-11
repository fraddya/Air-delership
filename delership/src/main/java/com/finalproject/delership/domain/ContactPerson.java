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
public class ContactPerson extends CreateModifyAwareBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String fullName;
    private String age;
    private String idNo;
    private String phoneNo;
    private GenderType genderType;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
