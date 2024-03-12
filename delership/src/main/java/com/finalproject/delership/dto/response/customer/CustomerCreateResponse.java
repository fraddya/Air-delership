package com.finalproject.delership.dto.response.customer;

import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.Status;
import lombok.Data;

@Data
public class CustomerCreateResponse {

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
}
