package com.finalproject.delership.domain.base;

import com.finalproject.delership.enums.RestApiResponseStatus;

public class SingleItemResponseWrapper<T> extends BaseResponseWrapper {
    private T content;

    public SingleItemResponseWrapper(T object, String message) {
        super(RestApiResponseStatus.OK);
        this.content = object;
        this.message = message;
    }

    public SingleItemResponseWrapper(T object) {
        super(RestApiResponseStatus.OK);
        this.content = object;
    }

    public T getContent() {
        return this.content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
