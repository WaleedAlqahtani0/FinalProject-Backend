package com.Project.CarRental.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_Book")
public class Book {

    // --------- Primary key (courseId) generated automatically by the database
    @Id
    private String bookCode;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "carId")
    private Car car;

    //---------- constructors, getters, setters, equals, hashCode and toString;
    public Book() {
    }

    public String getBookCode() {
        return bookCode;
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