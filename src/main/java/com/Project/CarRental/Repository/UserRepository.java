package com.Project.CarRental.Repository;

import com.Project.CarRental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
