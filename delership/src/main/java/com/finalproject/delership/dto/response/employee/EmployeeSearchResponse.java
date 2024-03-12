package com.finalproject.delership.dto.response.employee;

import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.Status;
import lombok.Data;

@Data
public class EmployeeSearchResponse {

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
