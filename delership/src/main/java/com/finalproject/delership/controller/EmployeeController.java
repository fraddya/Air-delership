package com.finalproject.delership.controller;

import com.finalproject.delership.domain.Employee;
import com.finalproject.delership.domain.base.PagingListResponseWrapper;
import com.finalproject.delership.domain.base.SingleItemResponseWrapper;
import com.finalproject.delership.domain.criteria.EmployeeCriteria;
import com.finalproject.delership.dto.request.employee.EmployeeCreateRequest;
import com.finalproject.delership.dto.request.employee.EmployeeSearchRequest;
import com.finalproject.delership.dto.response.employee.EmployeeCreateResponse;
import com.finalproject.delership.dto.response.employee.EmployeeSearchResponse;
import com.finalproject.delership.mapper.EmployeeMapper;
import com.finalproject.delership.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("${app.endpoint.employeesCreate}")
    public ResponseEntity<SingleItemResponseWrapper<EmployeeCreateResponse>> create(
            @Validated @RequestBody EmployeeCreateRequest request) {

        Employee employee = employeeMapper.mapToEmployee(request);

        Employee employee1 = employeeService.save(employee);

        EmployeeCreateResponse response = employeeMapper.mapToUpdateResponse(employee1);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.CREATED);
    }

    @PutMapping("${app.endpoint.employeesUpdate}")
    public ResponseEntity<SingleItemResponseWrapper<EmployeeCreateResponse>> update(
            @PathVariable Long id, @Validated @RequestBody EmployeeCreateRequest request) {

        Employee employee = employeeMapper.mapToEmployee(request);

        employee.setId(id);
        Employee updateEmployee = employeeService.update(employee);

        EmployeeCreateResponse response = employeeMapper.mapToUpdateResponse(updateEmployee);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.employeesSearch}")
    public ResponseEntity<PagingListResponseWrapper<EmployeeSearchResponse>> retrieve(
            @Validated EmployeeSearchRequest request) {

        EmployeeCriteria criteria = employeeMapper.mapToCriteria(request);

        Page<Employee> results = employeeService.search(criteria);

        List<EmployeeSearchResponse> responses = employeeMapper.mapToSearchResponse(results.getContent());

        PagingListResponseWrapper.Pagination pagination =
                new PagingListResponseWrapper.Pagination(
                        results.getNumber() + 1,
                        results.getSize(),
                        results.getTotalPages(),
                        results.getTotalElements());

        return new ResponseEntity<>(new PagingListResponseWrapper<>(responses, pagination), HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.employeesView}")
    public ResponseEntity<SingleItemResponseWrapper<EmployeeSearchResponse>> retrieve(
            @PathVariable Long id) {
        Employee employee = employeeService.retrieve(id);

        EmployeeSearchResponse response = employeeMapper.mapToEmployeeViewResponse(employee);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

    @DeleteMapping("${app.endpoint.employeesDelete}")
    public ResponseEntity<SingleItemResponseWrapper<EmployeeCreateResponse>> delete(
            @PathVariable Long id) {

        Employee employee = employeeService.delete(id);

        EmployeeCreateResponse response = new EmployeeCreateResponse();

        if (employee != null) {
            response = employeeMapper.mapToUpdateResponse(employee);
        }
        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }
}
