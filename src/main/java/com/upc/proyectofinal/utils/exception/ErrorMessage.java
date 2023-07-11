package com.upc.proyectofinal.utils.exception;

public class ErrorMessage {
    private int errorCode;
    private String message;
    private String description;

    public ErrorMessage(int errorCode, String message, String description) {
        this.errorCode = errorCode;
        this.message = message;
        this.description = description;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
