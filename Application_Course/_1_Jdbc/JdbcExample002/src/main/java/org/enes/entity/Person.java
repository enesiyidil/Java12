package org.enes.entity;

import java.util.Date;

public class Person {

    private int id;
    private String firtsName;
    private String lastName;
    private Date joinedDate;
    private String email;

    public Person() {
    }

    public Person(String firtsName, String lastName, String email) {
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.email = email;
    }

    public Person(int id, String firtsName, String lastName, Date joinedDate, String email) {
        this.id = id;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.joinedDate = joinedDate;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firtsName='" + firtsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", joinedDate=" + joinedDate +
                ", email='" + email + '\'' +
                '}';
    }
}
