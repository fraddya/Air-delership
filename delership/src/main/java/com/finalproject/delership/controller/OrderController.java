package com.finalproject.delership.controller;

import com.finalproject.delership.domain.Order;
import com.finalproject.delership.domain.base.PagingListResponseWrapper;
import com.finalproject.delership.domain.base.SingleItemResponseWrapper;
import com.finalproject.delership.domain.criteria.OrderCriteria;
import com.finalproject.delership.dto.request.order.OrderCreateRequest;
import com.finalproject.delership.dto.request.order.OrderSearchRequest;
import com.finalproject.delership.dto.response.order.OrderCreateResponse;
import com.finalproject.delership.dto.response.order.OrderSearchResponse;
import com.finalproject.delership.mapper.OrderMapper;
import com.finalproject.delership.service.OrderService;
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

public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;


    @PostMapping("${app.endpoint.orderCreate}")
    public ResponseEntity<SingleItemResponseWrapper<OrderCreateResponse>> create(
            @Validated @RequestBody OrderCreateRequest request) {

        Order order = orderMapper.mapToOrder(request);

        Order order1 = orderService.save(order);

        OrderCreateResponse response = orderMapper.mapToUpdateResponse(order1);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.CREATED);
    }

    @PutMapping("${app.endpoint.orderUpdate}")
    public ResponseEntity<SingleItemResponseWrapper<OrderCreateResponse>> update(
            @PathVariable Long id, @Validated @RequestBody OrderCreateRequest request) {

        Order order = orderMapper.mapToOrder(request);

        order.setId(id);

        Order updateOrder = orderService.update(order);

        OrderCreateResponse response = orderMapper.mapToUpdateResponse(updateOrder);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.orderSearch}")
    public ResponseEntity<PagingListResponseWrapper<OrderSearchResponse>> retrieve(
            @Validated OrderSearchRequest request) {

        OrderCriteria criteria = orderMapper.mapToCriteria(request);

        Page<Order> results = orderService.search(criteria);

        List<OrderSearchResponse> responses = orderMapper.mapToSearchResponse(results.getContent());

        PagingListResponseWrapper.Pagination pagination =
                new PagingListResponseWrapper.Pagination(
                        results.getNumber() + 1,
                        results.getSize(),
                        results.getTotalPages(),
                        results.getTotalElements());

        return new ResponseEntity<>(new PagingListResponseWrapper<>(responses,pagination),HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.orderView}")
    public ResponseEntity<SingleItemResponseWrapper<OrderSearchResponse>> retrieve(
            @PathVariable Long id) {

        Order order = orderService.retrieve(id);

        OrderSearchResponse response = orderMapper.mapToOrderViewResponse(order);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

    @DeleteMapping("${app.endpoint.orderDelete}")
    public ResponseEntity<SingleItemResponseWrapper<OrderCreateResponse>> delete(
            @PathVariable Long id) {

        Order order = orderService.delete(id);

        OrderCreateResponse response = new OrderCreateResponse();

        if (order != null) {
            response = orderMapper.mapToUpdateResponse(order);
        }
        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

}
