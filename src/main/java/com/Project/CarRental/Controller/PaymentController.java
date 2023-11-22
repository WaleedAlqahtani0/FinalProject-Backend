package com.Project.CarRental.Controller;


import com.Project.CarRental.Repository.PaymentRepository;
import com.Project.CarRental.Service.Imp.PaymentImp;
import com.Project.CarRental.entity.Payment;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
 * REST API for Payment
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentImp paymentImp;

    @Autowired
    private PaymentRepository paymentRepository;


    // Get Api
    @GetMapping("/carRental/payments")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getAllPayment() {
        return paymentImp.getAllPayment();
    }


    // Post or add
    @PostMapping("/carRental/payments/add")
    public ResponseEntity<String> addPayment(@RequestBody @Valid Payment payment) {
        try {
            paymentImp.addPayment(payment);
            String massage = "Payment add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Payment not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }

    @DeleteMapping("/carRental/payments/delete/{id}")
    public String deletePayment(@PathVariable String id) {
        Optional<Payment> UserFound = paymentRepository.findById(id);
        try {
            if (UserFound.isPresent()) {
                paymentImp.deletePayment(id);
                return "Payment Id deleted";
            } else {
                return "Payment with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Payment not deleted";
        }
    }

    @PutMapping("/carRental/payments/update/{id}")
    public String updatePayment(@PathVariable String id, @RequestBody Payment payment){
        return paymentImp.UpdatePayment(id,payment);
    }




}
