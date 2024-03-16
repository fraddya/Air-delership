package com.finalproject.delership.service;

import com.finalproject.delership.domain.Order;
import com.finalproject.delership.domain.criteria.OrderCriteria;
import org.springframework.data.domain.Page;

public interface OrderService {

    Order save(Order order);

    Page<Order> search(OrderCriteria criteria);

    Order retrieve(Long id);

    Order update(Order order);

    Order delete(Long id);
}
