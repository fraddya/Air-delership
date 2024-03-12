package com.finalproject.delership.service.Impl;

import com.finalproject.delership.domain.Employee;
import com.finalproject.delership.domain.criteria.EmployeeCriteria;
import com.finalproject.delership.enums.Status;
import com.finalproject.delership.repository.EmployeeRepository;
import com.finalproject.delership.service.EmployeeService;
import com.querydsl.core.BooleanBuilder;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        employee.setStatus(Status.ACTIVE);
        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> search(EmployeeCriteria criteria) {

        PageRequest page = PageRequest.of(criteria.getPageNumber() - 1, criteria.getPageSize(),
                Sort.by(Sort.Direction.fromOptionalString(criteria.getSortDirection()).orElse(Sort.Direction.DESC),
                        criteria.getSortProperty()));

        Page<Employee> employees = null;

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (booleanBuilder.hasValue()){
            employees = employeeRepository.findAll(booleanBuilder, page);
        } else {
            employees = employeeRepository.findAll(page);
        }
        return employees;
    }

    @Override
    public Employee retrieve(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException(String.format("Employee id (%s) not found", id)));
    }

    @Override
    public Employee update(Employee employee) {
        employee.setStatus(Status.ACTIVE);
        Optional<Employee> employeePersisted = employeeRepository.findById(employee.getId());
        if (employeePersisted.isPresent()) {
            if (employee.getAge() != null) {
                employeePersisted.get().setAge(employee.getAge());
            }
            if (employee.getFirstName() != null) {
                employeePersisted.get().setFirstName(employee.getFirstName());
            }
            if (employee.getLastName() != null) {
                employeePersisted.get().setLastName(employee.getLastName());
            }
            if (employee.getContactNo() != null) {
                employeePersisted.get().setContactNo(employee.getContactNo());
            }
            if (employee.getGenderType() != null) {
                employeePersisted.get().setGenderType(employee.getGenderType());
            }
            if (employee.getNic() != null) {
                employeePersisted.get().setNic(employee.getNic());
            }
            if (employee.getNationality() != null) {
                employeePersisted.get().setNationality(employee.getNationality());
            }
            if (employee.getReligion() != null) {
                employeePersisted.get().setReligion(employee.getReligion());
            }
            if (employee.getEmail() != null) {
                employeePersisted.get().setEmail(employee.getEmail());
            }
            if (employee.getUserLogging() != null) {
                employeePersisted.get().setUserLogging(employee.getUserLogging());
            }
            return employeeRepository.save(employeePersisted.get());
        } else {
            throw new EntityNotFoundException(String.format("Employee id (%s) not found", employeePersisted.get().getId()));
        }
    }



    @Override
    public Employee delete(Long id) {
        Employee employee = employeeRepository.getReferenceById(id);
        if (employee != null) {
            employee.setStatus(Status.DELETED);
            return employeeRepository.save(employee);
        }
        return null;
    }
}
