package com.finalproject.delership.controller;


import com.finalproject.delership.domain.Customer;
import com.finalproject.delership.domain.base.PagingListResponseWrapper;
import com.finalproject.delership.domain.base.SingleItemResponseWrapper;
import com.finalproject.delership.domain.criteria.CustomerCriteria;
import com.finalproject.delership.dto.request.customr.CustomerCreateRequest;
import com.finalproject.delership.dto.request.customr.CustomerSearchRequest;
import com.finalproject.delership.dto.response.customer.CustomerCreateResponse;
import com.finalproject.delership.dto.response.customer.CustomerSearchResponse;
import com.finalproject.delership.mapper.CustomerMapper;
import com.finalproject.delership.service.CustomerService;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "CustomerController", description = "create/search/view/update/delete")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping("${app.endpoint.customerCreate}")
    public ResponseEntity<SingleItemResponseWrapper<CustomerCreateResponse>> create(
            @Validated @RequestBody CustomerCreateRequest request) {

        Customer customer = customerMapper.mapToCustomer(request);

        Customer customer1 = customerService.save(customer);

        CustomerCreateResponse response = customerMapper.mapToUpdateResponse(customer1);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }


    @PutMapping("${app.endpoint.customerUpdate}")
    public ResponseEntity<SingleItemResponseWrapper<CustomerCreateResponse>> update(
            @PathVariable Long id, @Validated @RequestBody CustomerCreateRequest request) {

        Customer customer = customerMapper.mapToCustomer(request);

        customer.setId(id);
        Customer updateCustomer = customerService.update(customer);

        CustomerCreateResponse response = customerMapper.mapToUpdateResponse(updateCustomer);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.customerSearch}")
    public ResponseEntity<PagingListResponseWrapper<CustomerSearchResponse>> retrieve(
            @Validated CustomerSearchRequest request) {

        CustomerCriteria criteria = customerMapper.mapToCriteria(request);

        Page<Customer> results = customerService.search(criteria);

        List<CustomerSearchResponse> responses = customerMapper.mapToSearchResponse(results.getContent());

        PagingListResponseWrapper.Pagination pagination =
                new PagingListResponseWrapper.Pagination(
                        results.getNumber() + 1,
                        results.getSize(),
                        results.getTotalPages(),
                        results.getTotalElements());

        return new ResponseEntity<>(new PagingListResponseWrapper<>(responses, pagination),HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.customerView}")
    public ResponseEntity<SingleItemResponseWrapper<CustomerSearchResponse>> retrieve(
            @PathVariable Long id) {

        Customer customer = customerService.retrieve(id);

        CustomerSearchResponse response = customerMapper.mapToCustomerViewResponse(customer);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

    @DeleteMapping("${app.endpoint.customerDelete}")
    public ResponseEntity<SingleItemResponseWrapper<CustomerCreateResponse>> delete(
            @PathVariable Long id) {

        Customer customer = customerService.delete(id);

        CustomerCreateResponse response = new CustomerCreateResponse();

        if (customer != null) {
            response = customerMapper.mapToUpdateResponse(customer);
        }
        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }
}
