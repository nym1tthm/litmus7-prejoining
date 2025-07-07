package com.litmus7.urs.dto;



public class Response<T> {
    private String message;
    private T data;
    private int statusCode;
    
    public static int SUCCESS_REGISTRATION = 100;
    public static int ERROR_VALIDATION = 200;
    public static int ERROR_UNKNOWN = 201;


    public String getMessage() {return message;}
    
    public int getStatusCode() { return statusCode; }
    
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
    
    public void setMessage(String message) {this.message = message; }
    
    public T getData() {return data; }
    
    public void setData(T data) {this.data = data;}
}
