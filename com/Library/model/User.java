package com.Library.model;

public class User {
     private long userId;
     private String name;
     
     public User(long userId, String name){
        this.userId = userId;
        this.name = name;
     }
     public long getUserid(){
        return this.userId;
     }

     public String getName(){
        return this.name;
     }

     public void DisplayProfile(){
        System.out.println("User ID: " + this.userId);
        System.out.println("Name: " + this.name);
     }

}
