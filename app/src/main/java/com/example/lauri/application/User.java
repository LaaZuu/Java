package com.example.lauri.application;

public class User {
    private String name ="";
    private String address ="";
    private String phone ="";



    public void edit(String n, String a, String p){
        this.name = n;
        this.address = a;
        this.phone = p;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    private static final User user = new User();
    public static User getInstance() { return user;}

}