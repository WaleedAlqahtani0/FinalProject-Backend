package com.Project.CarRental.Controller;


import com.Project.CarRental.Repository.UserRepository;
import com.Project.CarRental.Service.Imp.UserImp;
import com.Project.CarRental.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


/*
 * REST API for User
 */
@RestController
public class UserController {

    /*
     -------- Autowired userImp for accessing user data
    */
    @Autowired
    private UserImp userImp;


    /*
      -------- Autowired UserRepository for accessing user data
     */
    @Autowired
    private UserRepository userRepository;


    /*--------------------
     - Get a list of all users
     - return list of all users
    */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userImp.getAllUsers();
    }

    /*------------------
           - add a new user
           - @RequestBody user the user to be saved
           - @Valid to validation
           - I used try-catch to check there is not give anu error or Exception when added
             */
    @PostMapping("/users/add")
    public ResponseEntity<String> addUsers(@RequestBody @Valid User user) {
        try {
            userImp.addUser(user);
            String massage = "User add successfully";
            return ResponseEntity.status(HttpStatus.OK).body(massage);
        } catch (Exception e) {
            String errorMassage = "User not found" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMassage);
        }
    }


    /*----------------------
      - Delete users with handling Exception
     */

    @DeleteMapping("/users/delete/{id}")
    public String deleteUsers(@PathVariable int id) {
        Optional<User> UserFound = userRepository.findById(id);
        try {
            if (UserFound.isPresent()) {
                userImp.deleteUser(id);
                return "User Id deleted";
            } else {
                return "User with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "User not deleted";
        }
    }

    /*----------------------
          - Update users and I did the Exception in UserImp class
         */
    @PutMapping("/users/update/{id}")
    public String updateUsers(@PathVariable int id, @RequestBody User user){
        return userImp.UpdateUser(id,user);
    }

}
