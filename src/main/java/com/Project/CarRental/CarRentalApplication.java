package com.Project.CarRental;

import com.Project.CarRental.Repository.UserRepository;
import com.Project.CarRental.entity.Role;
import com.Project.CarRental.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;

@SpringBootApplication
public class CarRentalApplication implements CommandLineRunner {

	@Autowired
	UserRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
			}
		};
	}
	@Override
	public void run(String... args) throws Exception {
		User adminAccount = usersRepository.findByroles(Role.ADMIN);
		if(adminAccount == null){
			User users = new User();
			users.setUsername("admin");
			users.setPassword(new BCryptPasswordEncoder().encode("admin"));
			users.setEmail("admin@gmail.com");

			users.setRoles(Role.ADMIN);
			usersRepository.save(users);
		}

	}


}
