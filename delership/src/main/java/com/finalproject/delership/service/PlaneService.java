package com.finalproject.delership.service;

import com.finalproject.delership.domain.Plane;
import com.finalproject.delership.domain.criteria.PlaneCriteria;
import org.springframework.data.domain.Page;

public interface PlaneService {

    Plane save(Plane plane);

    Page<Plane> search(PlaneCriteria criteria);

    Plane retrieve(Long id);

    Plane update(Plane plane);

    Plane delete(Long id);
}
