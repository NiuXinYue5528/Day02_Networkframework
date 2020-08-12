package com.example.day02_networkframework.food;

import com.google.gson.JsonElement;

public class Food {
     JsonElement data;
     int ret;

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }
}
