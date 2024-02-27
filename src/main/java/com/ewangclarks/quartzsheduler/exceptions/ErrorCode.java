package com.ewangclarks.quartzsheduler.exceptions;

enum ErrorCode {
    API_INTERNAL_SERVER_ERROR("API_INTERNAL_SERVER_ERROR");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
