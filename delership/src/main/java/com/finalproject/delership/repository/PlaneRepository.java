package com.finalproject.delership.repository;

import com.finalproject.delership.domain.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long>, QuerydslPredicateExecutor<Plane> {
}
