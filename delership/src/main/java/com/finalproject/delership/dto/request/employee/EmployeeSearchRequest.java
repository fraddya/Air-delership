package com.finalproject.delership.dto.request.employee;

import com.finalproject.delership.domain.base.BaseSearchRequest;
import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.Status;
import lombok.Data;

@Data
public class EmployeeSearchRequest extends BaseSearchRequest {

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
    private String password;
    private Status status;

    private String sortProperty = "lastModifiedAt";

    @Override
    public String getSortProperty() {
        return sortProperty;
    }
}
