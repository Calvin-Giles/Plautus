package com.example.serving_web_content;

public class LoginResponse {

    private String message;
    private boolean success;

    public LoginResponse() {
    }

    public LoginResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
