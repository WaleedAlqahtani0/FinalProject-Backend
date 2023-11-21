package com.Project.CarRental.Controller;

import com.Project.CarRental.DTO.BookDTO;
import com.Project.CarRental.Repository.BookRepository;
import com.Project.CarRental.Service.Imp.BookImp;
import com.Project.CarRental.entity.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookImp bookImp;

    @Autowired
    private BookRepository bookRepository;


    // Get
    @GetMapping("/carRental/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBook() {
        return bookImp.getAllBooks();
    }

    // Get by user id
    @GetMapping("/carRental/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBookByUserId(@PathVariable int id) {
        return bookImp.getBooksByUserId(id);
    }

    // post

    @PostMapping("/carRental/books/add")
    public ResponseEntity<String> addBooks(@RequestBody BookDTO bookDTO) {
        try {
            bookImp.addBook(bookDTO);
            String massage = "Booking add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "Booking not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }

    // delete
    @DeleteMapping("/carRental/books/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        Optional<Book> UserFound = bookRepository.findById(id);
        try {
            if (UserFound.isPresent()) {
                bookImp.deleteBook(id);
                return "Book Id deleted";
            } else {
                return "Book with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Book not deleted";
        }
    }

    @PutMapping("/carRental/books/update/{id}")
    public String updateBooks(@PathVariable String id, @RequestBody Book book){
        return bookImp.UpdateBook(id,book);
    }


}
