package com.Project.CarRental.Controller;


import com.Project.CarRental.DTO.JwtAuthenticationRequest;
import com.Project.CarRental.DTO.SignInRequest;
import com.Project.CarRental.DTO.SignUpRequest;
import com.Project.CarRental.Service.Imp.AuthenticationServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carRental/auth")
@NoArgsConstructor
public class AuthController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

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
}
