package com.finalproject.delership.dto.request.order;

import com.finalproject.delership.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderCreateRequest {

    @NotNull(message = "Order Price is required.")
    private String orderPrice;
    private LocalDateTime dateTime;

    private Status status;
}
