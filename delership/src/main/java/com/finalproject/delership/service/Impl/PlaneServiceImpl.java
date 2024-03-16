package com.finalproject.delership.service.Impl;

import com.finalproject.delership.domain.Plane;
import com.finalproject.delership.domain.base.ComplexValidationException;
import com.finalproject.delership.domain.criteria.PlaneCriteria;
import com.finalproject.delership.enums.Status;
import com.finalproject.delership.repository.PlaneRepository;
import com.finalproject.delership.service.PlaneService;
import com.querydsl.core.BooleanBuilder;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PlaneServiceImpl implements PlaneService {


    @Autowired
    private PlaneRepository planeRepository;


    @Override
    public Plane save(Plane plane) {
        plane.setStatus(Status.ACTIVE);
        return planeRepository.save(plane);
    }

    @Override
    public Page<Plane> search(PlaneCriteria criteria) {
        PageRequest page = PageRequest.of(criteria.getPageNumber() - 1, criteria.getPageSize(),
                Sort.by(Sort.Direction.fromOptionalString(criteria.getSortDirection()).orElse(Sort.Direction.DESC),
                        criteria.getSortProperty()));

        Page<Plane> planes = null;

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (booleanBuilder.hasValue()) {
            planes = planeRepository.findAll(booleanBuilder, page);
        } else {
            planes = planeRepository.findAll(page);
        }
        return planes;
    }

    @Override
    public Plane retrieve(Long id) {
        return planeRepository.findById(id).orElseThrow(()->
                new ComplexValidationException("Plane id (%s) not found", id.toString()));
    }

    @Override
    public Plane update(Plane plane) {
        plane.setStatus(Status.ACTIVE);
        Optional<Plane> planePersisted = planeRepository.findById(plane.getId());

        if (planePersisted.isPresent()) {
            if (plane.getName() != null) {
                planePersisted.get().setName(plane.getName());
            }
            if (plane.getImage() != null) {
                planePersisted.get().setImage(plane.getImage());
            }
            if (plane.getSheet() != null) {
                planePersisted.get().setSheet(plane.getSheet());
            }
            if (plane.getPrice() != null) {
                planePersisted.get().setPrice(plane.getPrice());
            }
            if (plane.getOld() != null) {
                planePersisted.get().setOld(plane.getOld());
            }
            if (plane.getWeight() != null) {
                planePersisted.get().setWeight(plane.getWeight());
            }
            if (plane.getFuel() != null) {
                planePersisted.get().setFuel(plane.getFuel());
            }
            if (plane.getSpeed() != null) {
                planePersisted.get().setSpeed(plane.getSpeed());
            }
            if (plane.getRange() != null) {
                planePersisted.get().setRange(plane.getRange());
            }
            if (plane.getPrimary() != null) {
                planePersisted.get().setPrimary(plane.getPrimary());
            }
            return planeRepository.save(planePersisted.get());
        }else {
            throw new ComplexValidationException("Customer id (%s) not found", planePersisted.get().getId().toString());
        }
    }

    @Override
    public Plane delete(Long id) {
        Plane plane = planeRepository.getReferenceById(id);
        if (plane != null) {
            plane.setStatus(Status.ACTIVE);
            return planeRepository.save(plane);
        }
        return null;
    }
}
