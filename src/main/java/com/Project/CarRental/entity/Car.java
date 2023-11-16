package com.Project.CarRental.entity;

import jakarta.persistence.*;

import java.util.Objects;

/*

   Car Entity

 */
@Entity
@Table(name = "tbl_Car")
public class Car {


    // --------- Primary key (id) generated automatically by the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //----------- attribute
    private String type;

    //----------- attribute
    private int model;

    //-----------  attribute
    private String color;



    //---------- constructors, getters, setters, equals, hashCode and toString;
    public Car() {
    }

    public Car(String type, int model, String color) {
        this.type = type;
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }



    public void setType(String type) {
        this.type = type;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && model == car.model && Objects.equals(type, car.type) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, model, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model=" + model +
                ", color='" + color + '\'' +
                '}';
    }
}
