package com.finalproject.delership.dto.request.customr;

import com.finalproject.delership.domain.base.BaseSearchRequest;
import com.finalproject.delership.enums.GenderType;
import com.finalproject.delership.enums.Status;
import lombok.Data;

@Data
public class CustomerSearchRequest extends BaseSearchRequest {

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

    private String sortProperty = "lastModifiedAt";

    @Override
    public String getSortProperty() {
        return sortProperty;
    }
}
