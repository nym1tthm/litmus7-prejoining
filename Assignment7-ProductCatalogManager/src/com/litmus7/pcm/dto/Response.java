package com.litmus7.pcm.dto;

public class Response<T> {
    private String message;
    private T data;
    private int statusCode;
    
    public static final int SUCCESS_CREATE = 100;
    public static final int SUCCESS_UPDATE = 101;
    public static final int SUCCESS_DELETE = 102;
    public static final int SUCCESS_SEARCH = 103;


    public static final int ERROR_VALIDATION = 200;
    public static final int ERROR_NOT_FOUND = 201;
    public static final int ERROR_UNKNOWN = 300;


    public String getMessage() {return message;}
    
    public int getStatusCode() { return statusCode; }
    
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
    
    public void setMessage(String message) {this.message = message; }
    
    public T getData() {return data; }
    
    public void setData(T data) {this.data = data;}
}
