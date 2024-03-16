package com.finalproject.delership.domain.base;

import java.util.List;

public class ComplexValidationException extends BaseException{

    private static final long serialVersionUID = 4502802173447729724L;
    private String field;
    private String code;
    private List<ValidationFailure> validationFailures;

    public ComplexValidationException(String field, String code) {
        this.field = field;
        this.code = code;
    }

    public ComplexValidationException(List<ValidationFailure> validationFailures) {
        this.validationFailures = validationFailures;
    }

    public String getField() {
        return this.field;
    }

    public String getCode() {
        return this.code;
    }

    public List<ValidationFailure> getValidationFailures() {
        return this.validationFailures;
    }

}
