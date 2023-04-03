package com.discaptraining.apidiscapuser.controllers.dto;

public class AuthenticacionResponse {
    private String access_token;

    public AuthenticacionResponse(String access_token) {
        this.access_token = access_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
