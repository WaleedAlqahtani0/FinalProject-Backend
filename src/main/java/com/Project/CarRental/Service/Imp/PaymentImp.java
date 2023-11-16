package com.Project.CarRental.Service.Imp;

import com.Project.CarRental.Repository.PaymentRepository;
import com.Project.CarRental.Service.interfaces.PaymentServices;
import com.Project.CarRental.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentImp implements PaymentServices {


    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(String id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public String UpdatePayment(String id, Payment payment) {

        Payment PaymentFound = paymentRepository.findById(id).get();
        try {
            if (PaymentFound != null) {

                PaymentFound.setCodeNumber(payment.getCodeNumber());

                paymentRepository.save(PaymentFound);
                return "Payment Details Updated";
            } else {
                return "Payment with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Payment Not Updated";
        }
    }
}
