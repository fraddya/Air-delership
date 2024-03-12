package com.finalproject.delership.service;

import com.finalproject.delership.domain.Customer;
import com.finalproject.delership.domain.criteria.CustomerCriteria;
import org.springframework.data.domain.Page;

public interface CustomerService {

    Customer save(Customer customer);

    Page<Customer> search(CustomerCriteria criteria);

    Customer retrieve(Long id);

    Customer update(Customer customer);

    Customer delete(Long id);
}
