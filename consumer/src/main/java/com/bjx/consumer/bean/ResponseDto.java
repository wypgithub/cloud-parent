package com.bjx.consumer.bean;

/**
 * return object of Response
 */
public class ResponseDto {
    //Whether the request was successful
    private boolean success;

    //Error message returned by request failure
    private String message;

    public ResponseDto(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
