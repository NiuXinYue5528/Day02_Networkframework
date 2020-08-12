package com.example.http_library.Exception;

public class ServerException extends RuntimeException {
    private String msg;
    private int code;

    public ServerException(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
