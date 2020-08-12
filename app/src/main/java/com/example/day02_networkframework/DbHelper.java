package com.example.day02_networkframework;

public class DbHelper {
    private static volatile DbHelper instance;

    public static DbHelper getInstance() {
        if (instance==null){
            synchronized (DbHelper.class){
                if (instance==null){
                    instance=new DbHelper();
                }
            }
        }
        return instance;
    }

    private DbHelper() {

    }
    public void  insert(){

    }

}
