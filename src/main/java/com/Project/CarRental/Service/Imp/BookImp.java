package com.Project.CarRental.Service.Imp;

import com.Project.CarRental.DTO.BookDTO;
import com.Project.CarRental.Repository.BookRepository;
import com.Project.CarRental.Repository.CarRepository;
import com.Project.CarRental.Repository.PaymentRepository;
import com.Project.CarRental.Repository.UserRepository;
import com.Project.CarRental.Service.interfaces.BookServices;
import com.Project.CarRental.entity.Book;
import com.Project.CarRental.entity.Car;
import com.Project.CarRental.entity.Payment;
import com.Project.CarRental.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookImp implements BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByUserId(int userId) {
        return bookRepository.findAllByUserId(userId);
    }

    @Override
    public Book addBook(BookDTO book) {
        User user = userRepository.findById(book.getUserId()).get();
        Car car = carRepository.findById(book.getCarId()).get();
        Book bookEntity = new Book();
        String bookCode = UUID.randomUUID().toString().substring(0, 7);
        bookEntity.setBookCode(bookCode);
        bookEntity.setCar(car);
        bookEntity.setUser(user);
        bookEntity.setNationalID(book.getNationalID());
        bookEntity.setStartDate(book.getStartDate());
        bookEntity.setEndDate(book.getEndDate());
        bookEntity.setLocation(book.getLocation());
        bookEntity = bookRepository.save(bookEntity);
        Payment payment = new Payment();
        payment.setCodeNumber(bookCode);
        payment.setCardType("VISA");
        payment.setUser(user);
        payment.setBook(bookEntity);

        paymentRepository.save(payment);

        return bookEntity;
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    @Override
    public String UpdateBook(String id, Book book) {
        Book bookFound = bookRepository.findById(id).get();
        try {
            if (bookFound != null) {

                bookFound.setBookCode(book.getBookCode());
                bookRepository.save(bookFound);
                return "Book Details Updated";
            } else {
                return "Book with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Not Updated";
        }
    }
 }

