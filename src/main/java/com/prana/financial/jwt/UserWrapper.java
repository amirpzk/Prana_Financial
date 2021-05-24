package com.prana.financial.jwt;

public class UserWrapper {

    private static String ID = "ID";
    private static String USERNAME = "phone-number";
    private long id;
    private String username;


    public UserWrapper(long id ,String username){
        this.id = id;
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
