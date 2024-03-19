package com.finalproject.delership.mapper;

import com.finalproject.delership.domain.Order;
import com.finalproject.delership.domain.criteria.OrderCriteria;
import com.finalproject.delership.dto.request.order.OrderCreateRequest;
import com.finalproject.delership.dto.request.order.OrderSearchRequest;
import com.finalproject.delership.dto.response.order.OrderCreateResponse;
import com.finalproject.delership.dto.response.order.OrderSearchResponse;
import com.finalproject.delership.enums.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",imports = {Status.class})
public interface OrderMapper {

    Order mapToOrder(OrderCreateRequest request);

    OrderCriteria mapToCriteria(OrderSearchRequest request);

    List<OrderSearchResponse> mapToSearchResponse(List<Order> content);

    OrderSearchResponse mapToOrderViewResponse(Order order);

    OrderCreateResponse mapToUpdateResponse(Order orderUpdate);
}
