package com.ibc.keycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SpringBootKeycloakExampleApplication {
    //this method can be accessed by user whose role is user
	public String home() {
		return "Greetings from Spring Boot Service A!";
	}

	@GetMapping("/users")
	@RolesAllowed("user")
	public String users() {
		return "Greetings User!";
	}

	@GetMapping("/admins")
    @RolesAllowed("admin")
	public String admins() {
		return "Greetings Admin!";
	}

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKeycloakExampleApplication.class, args);
    }

}
