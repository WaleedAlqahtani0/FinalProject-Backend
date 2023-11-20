package com.Project.CarRental.Service.Imp;

import com.Project.CarRental.DTO.JwtAuthenticationRequest;
import com.Project.CarRental.DTO.SignInRequest;
import com.Project.CarRental.DTO.SignUpRequest;
import com.Project.CarRental.Repository.UserRepository;
import com.Project.CarRental.Service.interfaces.AuthenticationService;
import com.Project.CarRental.Service.interfaces.JWTService;
import com.Project.CarRental.entity.Role;
import com.Project.CarRental.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    @Autowired
    private UserRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;


    @Override
    public User signUp(SignUpRequest signUpRequest) {
        User users = new User();

        users.setUsername(signUpRequest.getUsername());
        users.setEmail(signUpRequest.getEmail());
        users.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        users.setRoles(Role.USER);
        return usersRepository.save(users);
    }

    @Override
    public JwtAuthenticationRequest signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.getUsername(), signInRequest.getPassword()));
        var users = usersRepository.findByusername(signInRequest.getUsername());
        if(users == null){
            throw new UsernameNotFoundException("User not found");
        }
        var token = jwtService.generateToken(users);
        JwtAuthenticationRequest jwtAuthenticationRequest = new JwtAuthenticationRequest();

        jwtAuthenticationRequest.setToken(token);
        return jwtAuthenticationRequest;
    }
}


