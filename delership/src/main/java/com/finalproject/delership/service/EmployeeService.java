package com.finalproject.delership.service;

import com.finalproject.delership.domain.Employee;
import com.finalproject.delership.domain.criteria.EmployeeCriteria;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Employee save(Employee employee);

    Page<Employee> search(EmployeeCriteria criteria);

    Employee retrieve(Long id);

    Employee update(Employee employee);

    Employee delete(Long id);
}
