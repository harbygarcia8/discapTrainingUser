package com.discaptraining.apidiscapuser.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;


public class CustomResponse {
    private String code;
    private String message;
    private int state;
    private Object results;

    public CustomResponse() {}

    public CustomResponse(String message, HttpStatus state) {
        this.message = message;
        this.state = state.value();
        this.code = state.name();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Object getresults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }
}