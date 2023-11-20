package com.Project.CarRental.Service.Imp;


import com.Project.CarRental.Repository.UserRepository;
import com.Project.CarRental.Service.interfaces.UserServices;
import com.Project.CarRental.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

    /*
       UserImp implements UserService
    */
@Service
@RequiredArgsConstructor
public class UserImp implements UserServices {

    /*
     -------- Autowired UserRepository for database operations.
    */
    @Autowired
     UserRepository userRepository;


        /*
           ------ get all the users by findAll()
            */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

        @Override
        public User findUserById(int id) {
            return userRepository.findById(id).get();
        }

        /*
        --------- add a new user to the database
         */
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    /*
     ---------delete a users to the database
     */
    @Override
    public void deleteUser(Integer id) {
    userRepository.deleteById(id);

    }

     /*
       --------- Update a users to the database and check if the user not found give a massage
       --------- I used if else inside try-catch to if there is exceptions.
      */

    @Override
    public String UpdateUser(int id, User user) {
        User UserFound = userRepository.findById(id).get();
        try {
            if (UserFound != null) {

                UserFound.setUsername(user.getUsername());

                userRepository.save(UserFound);
                return "User Details Updated";
            } else {
                return "User with user id " + id + " not found";
            }
        } catch (Exception e) {
            return "Users Not Updated";
        }
    }


        @Override
        public UserDetailsService userDetailsService() {
            return new UserDetailsService() {
                @Override
                public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                    UserDetails userDetails = userRepository.findByusername(username);
                    if(userDetails == null){
                        throw new UsernameNotFoundException("User not found");
                    }
                    return userDetails;
                }
            };
        }

    }
