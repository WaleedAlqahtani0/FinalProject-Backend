package com.Project.CarRental.Service.interfaces;

import com.Project.CarRental.DTO.BookDTO;
import com.Project.CarRental.entity.Book;

import java.util.List;

/*

  The BookService is an interface that defines the methods that are available to perform operations on User entities.

 */

public interface BookServices {

    /*

     List of methods to show all Books, add , delete and update.

    */
    public List<Book> getAllBooks();

    public Book addBook(BookDTO book);

    public void deleteBook(String id);

    public String UpdateBook(String id, Book book);
}
