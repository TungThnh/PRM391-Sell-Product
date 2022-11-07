package com.prm.prm391_sellproduct.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private Boolean result;
    private String message;
    private String id_token;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }
}
