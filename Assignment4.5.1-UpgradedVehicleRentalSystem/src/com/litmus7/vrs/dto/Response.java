package com.litmus7.vrs.dto;

public class Response<T> {
    private int statusCode;
    private String errorMessage;
    private String errorDetails;
    private T data;


    public static int SUCCESS_FILE_RETRIEVED = 101;
    public static int ERROR_FILE_NOT_FOUND = 102;
    public static int SUCCESS_RENTAL = 201;
    public static int ERROR_RENTAL_INVALID = 202;


    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public String getErrorDetails() { return errorDetails; }
    public void setErrorDetails(String errorDetails) { this.errorDetails = errorDetails; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
