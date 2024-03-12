package com.finalproject.delership.domain.criteria;

import com.finalproject.delership.domain.Customer;
import lombok.Data;

@Data
public class CustomerCriteria extends Customer {

    private String keyword;

    private Integer pageNumber;

    private Integer pageSize;

    private String sortProperty;

    private String sortDirection;
}
