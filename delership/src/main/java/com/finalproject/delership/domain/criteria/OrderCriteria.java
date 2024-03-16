package com.finalproject.delership.domain.criteria;

import com.finalproject.delership.domain.Order;
import lombok.Data;

@Data
public class OrderCriteria extends Order {

    private String keyword;

    private Integer pageNumber;

    private Integer pageSize;

    private String sortProperty;

    private String sortDirection;
}
