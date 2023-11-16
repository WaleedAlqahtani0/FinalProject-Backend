package com.Project.CarRental.Service.interfaces;

import com.Project.CarRental.entity.Car;

import java.util.List;

/*

  The CarService is an interface that defines the methods that are available to perform operations on User entities.

 */

public interface CarServices {

    /*

    List of methods to show all Cars, add , delete and update.

   */
    public List<Car> getAllCars();

    public Car addCar(Car car);

    public void deleteCar(Integer id);

    public String UpdateCar(int id, Car car);
}
