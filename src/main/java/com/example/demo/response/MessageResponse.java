package com.example.demo.response;

public class MessageResponse extends BaseResponse {
    private String message;

    public MessageResponse() {
        super();
    }

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse(boolean status, String message) {
        super(status);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
