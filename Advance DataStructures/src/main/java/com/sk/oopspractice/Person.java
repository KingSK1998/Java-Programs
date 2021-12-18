package com.sk.oopspractice;

public class Person {
    private String name;
    private String rollno;
    
    public Person(String name, String rollno) {
        this.name = name;
        this.rollno = rollno;
    }
    
    public String getName() {return this.name;}
    
    public String getPerson() {
        return "Name: " + this.name + "\tRollno: " + this.rollno;
    }
}
