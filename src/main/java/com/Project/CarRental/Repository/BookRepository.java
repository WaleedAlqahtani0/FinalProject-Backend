package com.Project.CarRental.Repository;

import com.Project.CarRental.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
