package com.Project.CarRental.Repository;

import com.Project.CarRental.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,String> {

    List<Book> findAllByUserId(int userId);
}
