package com.Project.CarRental.Service.interfaces;

import com.Project.CarRental.entity.Payment;
import java.util.List;

/*

  The PaymentService is an interface that defines the methods that are available to perform operations on User entities.

 */
public interface PaymentServices {

    /*

     List of methods to show all payment, add , delete and update

    */

    public List<Payment> getAllPayment();

    public Payment addPayment(Payment payment);

    public void deletePayment(String id);

    public String UpdatePayment(String id, Payment payment);
}
