package com.spring.beebeta.authention;

public class TokenResponse {
    private String token;

    // Constructor
    public TokenResponse(String token) {
        this.token = token;
    }

    // Getter và setter (nếu cần)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
