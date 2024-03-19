package com.finalproject.delership.dto.request.order;

import com.finalproject.delership.domain.base.BaseSearchRequest;
import com.finalproject.delership.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderSearchRequest extends BaseSearchRequest {

    private Long id;

    private String orderPrice;
    private LocalDateTime dateTime;

    private Status status;

    private String sortProperty = "lastModifiedAt";

    @Override
    public String getSortProperty() {
        return sortProperty;
    }
}
