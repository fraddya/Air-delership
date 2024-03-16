package com.finalproject.delership.service.Impl;

import com.finalproject.delership.domain.Customer;
import com.finalproject.delership.domain.base.ComplexValidationException;
import com.finalproject.delership.domain.criteria.CustomerCriteria;
import com.finalproject.delership.enums.Status;
import com.finalproject.delership.repository.CustomerRepository;
import com.finalproject.delership.service.CustomerService;
import com.querydsl.core.BooleanBuilder;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer save(Customer customer) {
        customer.setStatus(Status.ACTIVE);
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> search(CustomerCriteria criteria) {
        PageRequest page = PageRequest.of(criteria.getPageNumber() - 1, criteria.getPageSize(),
                Sort.by(Sort.Direction.fromOptionalString(criteria.getSortDirection()).orElse(Sort.Direction.DESC),
                        criteria.getSortProperty()));

        Page<Customer> customers = null;

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (booleanBuilder.hasValue()) {
            customers = customerRepository.findAll(booleanBuilder, page);
        } else {
            customers = customerRepository.findAll(page);
        }
        return customers;
    }

    @Override
    public Customer retrieve(Long id) {
        return customerRepository.findById(id).orElseThrow(()->
                new ComplexValidationException("Customer id (%s) not found", id.toString()));
    }

    @Override
    public Customer update(Customer customer) {
        customer.setStatus(Status.ACTIVE);
        Optional<Customer> customerPersisted = customerRepository.findById(customer.getId());
        if (customerPersisted.isPresent()) {
            if (customer.getAge() != null) {
                customerPersisted.get().setAge(customer.getAge());
            }
            if (customer.getFirstName() != null) {
                customerPersisted.get().setFirstName(customer.getFirstName());
            }
            if (customer.getLastName() != null) {
                customerPersisted.get().setLastName(customer.getLastName());
            }
            if (customer.getContactNo() != null) {
                customerPersisted.get().setContactNo(customer.getContactNo());
            }
            if (customer.getGenderType() != null) {
                customerPersisted.get().setGenderType(customer.getGenderType());
            }
            if (customer.getNic() != null) {
                customerPersisted.get().setNic(customer.getNic());
            }
            if (customer.getEmail() != null) {
                customerPersisted.get().setEmail(customer.getEmail());
            }
            if (customer.getCountry() != null ){
                customerPersisted.get().setCountry(customer.getCountry());
            }
            return customerRepository.save(customerPersisted.get());
        }else {
            throw new ComplexValidationException("Customer id (%s) not found {}", customerPersisted.get().getId().toString());
        }
    }

    @Override
    public Customer delete(Long id) {
        Customer customer = customerRepository.getReferenceById(id);
        if (customer != null) {
            customer.setStatus(Status.DELETED);
            return customerRepository.save(customer);
        }
        return null;
    }
}
