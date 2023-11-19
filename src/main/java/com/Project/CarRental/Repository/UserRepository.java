package com.Project.CarRental.Repository;

import com.Project.CarRental.entity.Role;
import com.Project.CarRental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByusername(String name);
    User findByroles(Role roles);
}
