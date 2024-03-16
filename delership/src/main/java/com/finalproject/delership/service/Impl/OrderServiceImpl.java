package com.finalproject.delership.service.Impl;

import com.finalproject.delership.domain.Order;
import com.finalproject.delership.domain.base.ComplexValidationException;
import com.finalproject.delership.domain.criteria.OrderCriteria;
import com.finalproject.delership.enums.Status;
import com.finalproject.delership.repository.OrderRepository;
import com.finalproject.delership.service.OrderService;
import com.querydsl.core.BooleanBuilder;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        order.setStatus(Status.ACTIVE);
        order.setDateTime(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public Page<Order> search(OrderCriteria criteria) {
        PageRequest page = PageRequest.of(criteria.getPageNumber() - 1, criteria.getPageSize(),
                Sort.by(Sort.Direction.fromOptionalString(criteria.getSortDirection()).orElse(Sort.Direction.DESC),
                        criteria.getSortProperty()));

        Page<Order> orders = null;

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if (booleanBuilder.hasValue()) {
            orders = orderRepository.findAll(booleanBuilder, page);
        }else {
            orders = orderRepository.findAll(page);
        }
        return orders;
    }

    @Override
    public Order retrieve(Long id) {
        return orderRepository.findById(id).orElseThrow(()->
                new ComplexValidationException("Order id (%s) not found", id.toString()));
    }

    @Override
    public Order update(Order order) {
        order.setStatus(Status.ACTIVE);
        Optional<Order> orderPersisted = orderRepository.findById(order.getId());
        if (orderPersisted.isPresent()) {
            if (order.getOrderPrice() != null) {
                orderPersisted.get().setOrderPrice(order.getOrderPrice());
            }
            if (order.getDateTime() != null ) {
                orderPersisted.get().setDateTime(order.getDateTime());
            }
            return orderRepository.save(orderPersisted.get());
        }else {
            throw new ComplexValidationException("Order id (%s) not found", orderPersisted.get().getId().toString());
        }
    }

    @Override
    public Order delete(Long id) {
        Order order = orderRepository.getReferenceById(id);
        if (order != null) {
            order.setStatus(Status.DELETED);
            return orderRepository.save(order);
        }
        return null;
    }
}
