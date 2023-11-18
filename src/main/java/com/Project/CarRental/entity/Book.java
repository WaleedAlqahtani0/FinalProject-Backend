package com.Project.CarRental.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "tbl_Book")
public class Book {

    // --------- Primary key (courseId) generated automatically by the database
    @Id
    private String bookCode;

    private int nationalID;
    private String startDate;
    private String endDate;
    private String location;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "carId")
    private Car car;

    @OneToOne (mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;



    //---------- constructors, getters, setters, equals, hashCode and toString;
    public Book() {
    }

    public Book(String bookCode, String startDate, String endDate, String location,int nationalID) {
        this.bookCode = bookCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.nationalID=nationalID;
    }

    public String getBookCode() {
        return bookCode;
    }

    public int getNationalID() {
        return nationalID;
    }

    public void setNationalID(int nationalID) {
        this.nationalID = nationalID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}