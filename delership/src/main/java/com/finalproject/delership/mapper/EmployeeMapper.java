package com.finalproject.delership.mapper;

import com.finalproject.delership.domain.Employee;
import com.finalproject.delership.domain.criteria.EmployeeCriteria;
import com.finalproject.delership.dto.request.employee.EmployeeCreateRequest;
import com.finalproject.delership.dto.request.employee.EmployeeSearchRequest;
import com.finalproject.delership.dto.response.employee.EmployeeCreateResponse;
import com.finalproject.delership.dto.response.employee.EmployeeSearchResponse;
import com.finalproject.delership.enums.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",imports = {Status.class})
public interface EmployeeMapper {

    Employee mapToEmployee(EmployeeCreateRequest request);

    EmployeeCriteria mapToCriteria(EmployeeSearchRequest request);

    List<EmployeeSearchResponse> mapToSearchResponse(List<Employee> content);

    EmployeeSearchResponse mapToEmployeeViewResponse(Employee employee);

    EmployeeCreateResponse mapToUpdateResponse(Employee employeeUpdate);

}
