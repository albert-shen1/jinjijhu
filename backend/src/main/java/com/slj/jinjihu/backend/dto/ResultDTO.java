package com.slj.jinjihu.backend.dto;

public class ResultDTO {
    public final static int SUCCESS_CODE = 200;
    public final static int FAIl_CODE = 500;
    public final static int UNAUTHORIZED = 401;
    private String message;
    private int code;
    private Object data;

    public ResultDTO(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultDTO(String message) {
        this.message = message;
        this.code = FAIl_CODE;
    }

    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static int getFAIl_CODE() {
        return FAIl_CODE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
