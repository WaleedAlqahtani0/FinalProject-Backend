package com.Project.CarRental.Service.Imp;

import com.Project.CarRental.Repository.BookRepository;
import com.Project.CarRental.Service.interfaces.BookServices;
import com.Project.CarRental.entity.Book;
import com.Project.CarRental.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImp implements BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
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

