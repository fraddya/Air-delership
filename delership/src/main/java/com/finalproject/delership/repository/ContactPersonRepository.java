package com.finalproject.delership.repository;

import com.finalproject.delership.domain.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long>, QuerydslPredicateExecutor<ContactPersonRepository> {
}
