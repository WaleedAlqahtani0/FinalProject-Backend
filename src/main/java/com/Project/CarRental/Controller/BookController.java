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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<?> deleteBook(@PathVariable String id) {
        Optional<Book> UserFound = bookRepository.findById(id);
        try {
                bookImp.deleteBook(id);
                String message = "user deleted";
            Map<String, String> response = new HashMap<>();
            return ResponseEntity.status(HttpStatus.OK).body(response);
            }
         catch (Exception e) {
        String message = "user not deleted";
        return ResponseEntity.badRequest().body(message);
        }
    }

    @PutMapping("/carRental/books/update/{id}")
    public String updateBooks(@PathVariable String id, @RequestBody Book book){
        return bookImp.UpdateBook(id,book);
    }


}
