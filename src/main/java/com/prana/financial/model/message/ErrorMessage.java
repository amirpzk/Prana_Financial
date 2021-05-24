package com.prana.financial.model.message;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorMessage {

    private Date date;
    private int status;
    private String message;
    private List<FieldMessage> fieldMessages;

    public Date getDate() {
        return date;
    }

    public ErrorMessage setDate(Date date) {
        this.date = date;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ErrorMessage setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public List<FieldMessage> getFieldMessages() {
        return fieldMessages;
    }

    public ErrorMessage setFieldMessages(List<FieldError> fieldErrors) {
        this.fieldMessages = new ArrayList<>();
        fieldErrors.forEach(fieldError -> this.fieldMessages.add(new FieldMessage(fieldError.getField(), fieldError.getRejectedValue(),
                fieldError.getDefaultMessage(), fieldError.getCode(), fieldError.getCodes())));
        return this;
    }
}
