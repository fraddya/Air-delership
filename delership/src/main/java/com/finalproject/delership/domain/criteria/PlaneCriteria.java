package com.finalproject.delership.domain.criteria;

import com.finalproject.delership.domain.Plane;
import lombok.Data;

@Data
public class PlaneCriteria extends Plane {

    private String keyword;

    private Integer pageNumber;

    private Integer pageSize;

    private String sortProperty;

    private String sortDirection;
}
