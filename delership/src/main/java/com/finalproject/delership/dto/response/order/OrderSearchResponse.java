package com.finalproject.delership.dto.response.order;

import com.finalproject.delership.domain.base.BaseSearchRequest;
import com.finalproject.delership.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderSearchResponse {

    private Long id;

    private String orderPrice;
    private LocalDateTime dateTime;

    private Status status;

}
