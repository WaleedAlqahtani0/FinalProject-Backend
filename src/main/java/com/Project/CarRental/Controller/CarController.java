package com.Project.CarRental.Controller;

import com.Project.CarRental.Repository.CarRepository;
import com.Project.CarRental.Service.Imp.CarImp;
import com.Project.CarRental.entity.Car;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    private CarImp carImp;

    @Autowired
    private CarRepository carRepository;

    // Get

    @GetMapping("/carRental/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCars() {
        return carImp.getAllCars();
    }

    @GetMapping("/carRental/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCarId(@PathVariable int id){
        return carImp.getCarId(id);
    }

    // Post -- Add

    @PostMapping("/cars/add")
    public ResponseEntity<String> addCars(@RequestBody @Valid Car car) {
        try {
            carImp.addCar(car);
            String massage = "Car add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Car not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }


    // Delete
    @DeleteMapping("/cars/delete/{id}")
    public String deleteCars(@PathVariable int id) {
        Optional<Car> carFound = carRepository.findById(id);
        try {
            if (carFound.isPresent()) {
                carImp.deleteCar(id);
                return "Car Id deleted";
            } else {
                return "Car with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Car not deleted";
        }
    }

    // Update

    @PutMapping("/cars/update/{id}")
    public String updateCars(@PathVariable int id, @RequestBody Car car){
        return carImp.UpdateCar(id,car);
    }

}
