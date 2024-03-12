package com.finalproject.delership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPersonRepository, Long>, QuerydslPredicateExecutor<ContactPersonRepository> {
}
