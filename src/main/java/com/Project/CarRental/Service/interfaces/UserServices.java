package com.Project.CarRental.Service.interfaces;

import com.Project.CarRental.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/*

  The UserService is an interface that defines the methods that are available to perform operations on User entities.

 */

public interface UserServices {

    /*

     List of methods to show all users, add , delete and update Users.

    */

    public List<User> getAllUsers();

    public User addUser(User user);

    public void deleteUser(Integer id);

    public String UpdateUser(int id, User user);

    public UserDetailsService userDetailsService();
}
