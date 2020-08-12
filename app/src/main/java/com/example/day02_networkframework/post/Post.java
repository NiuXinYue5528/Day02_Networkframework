package com.example.day02_networkframework.post;

import java.io.Serializable;

public class Post<T> implements Serializable {
    private T record;
    private int status;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
