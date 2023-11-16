package com.Project.CarRental.Service.Imp;

import com.Project.CarRental.Repository.CarRepository;
import com.Project.CarRental.Service.interfaces.CarServices;
import com.Project.CarRental.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarImp implements CarServices {

    @Autowired
    private CarRepository carRepository;


    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Integer id) {
        carRepository.deleteById(id);

    }

    @Override
    public String UpdateCar(int id, Car car) {
        Car carFound = carRepository.findById(id).get();
        try {
            if (carFound != null) {
                carFound.setType(car.getType());
                carRepository.save(carFound);
                return "Car Details Updated";
            } else {
                return "Car with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Not Updated";
        }
    }
}

