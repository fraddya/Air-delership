package com.finalproject.delership.dto.request.employee;

import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeCreateRequest {

    @NotNull(message = "FirstName is required.")
    private String firstName;

    @NotNull(message = "LastName is required.")
    private String lastName;

    @NotNull(message = "Contact No is required.")
    private String contactNo;

    private String dateJoin;

    @NotNull(message = "Age is required.")
    private Integer age;

    @NotNull(message = "Gender Type is required.")
    private GenderType genderType;

    @NotNull(message = "Nic is required.")
    private String nic;

    private String nationality;
    private String image;
    private String religion;
    private String email;
    private String userLogging;
    private Status status;
}
