package com.finalproject.delership.domain.criteria;

import com.finalproject.delership.domain.Employee;
import lombok.Data;

@Data
public class EmployeeCriteria extends Employee {

    private String keyword;

    private Integer pageNumber;

    private Integer pageSize;

    private String sortProperty;

    private String sortDirection;

}
