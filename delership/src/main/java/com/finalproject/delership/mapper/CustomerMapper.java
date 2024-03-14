package com.finalproject.delership.mapper;

import com.finalproject.delership.domain.Customer;
import com.finalproject.delership.domain.criteria.CustomerCriteria;
import com.finalproject.delership.dto.request.customr.CustomerCreateRequest;
import com.finalproject.delership.dto.request.customr.CustomerSearchRequest;
import com.finalproject.delership.dto.response.customer.CustomerCreateResponse;
import com.finalproject.delership.dto.response.customer.CustomerSearchResponse;
import com.finalproject.delership.enums.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",imports = {Status.class})
public interface CustomerMapper {

    Customer mapToCustomer(CustomerCreateRequest request);

    CustomerCriteria mapToCriteria(CustomerSearchRequest request);

    List<CustomerSearchResponse> mapToSearchResponse(List<Customer> content);

    CustomerSearchResponse mapToCustomerViewResponse(Customer customer);

    CustomerCreateResponse mapToUpdateResponse(Customer customerUpdate);
}
