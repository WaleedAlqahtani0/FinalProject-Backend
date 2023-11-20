package com.Project.CarRental.Controller;


import com.Project.CarRental.DTO.JwtAuthenticationRequest;
import com.Project.CarRental.DTO.SignInRequest;
import com.Project.CarRental.DTO.SignUpRequest;
import com.Project.CarRental.DTO.UserVerify;
import com.Project.CarRental.Repository.UserRepository;
import com.Project.CarRental.Service.Imp.AuthenticationServiceImpl;
import com.Project.CarRental.entity.User;
import lombok.NoArgsConstructor;
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping(value = "/carRental/auth")
@NoArgsConstructor
public class AuthController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest signUpRequest){
        try{
            authenticationService.signUp(signUpRequest);
            String message = "your account added successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        }
        catch (Exception e){
            String message = "account not added\n" + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<JwtAuthenticationRequest> signin(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @GetMapping("/verify")
    public UserVerify verifyToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        User userFromDb = userRepository.findByusername(user.getUsername());
        UserVerify userVerify = new UserVerify(userFromDb.getId(), userFromDb.getUsername(), userFromDb.getRoles());
        return userVerify;
    }
}
