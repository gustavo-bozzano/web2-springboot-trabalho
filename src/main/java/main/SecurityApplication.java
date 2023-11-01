package main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import auth.AuthenticationService;
import auth.RegisterRequest;
import user.Role;

@SpringBootApplication
@ComponentScan(basePackages = {
        "auth",
        "book",
        "config",
        "demo",
        "token",
        "user"
})
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    // @Bean
    // public CommandLineRunner commandLineRunner(
    //         AuthenticationService service) {
    //     return args -> {
    //         var admin = RegisterRequest.builder()
    //                 .firstname("Admin")
    //                 .lastname("Admin")
    //                 .email("admin@mail.com")
    //                 .password("password")
    //                 .role(Role.ADMIN)
    //                 .build();
    //         System.out.println("Admin token: " + service.register(admin).getToken());

    //         var user = RegisterRequest.builder()
    //                 .firstname("User")
    //                 .lastname("User")
    //                 .email("user@mail.com")
    //                 .password("password")
    //                 .role(Role.USER)
    //                 .build();
    //         System.out.println("Manager token: " + service.register(user).getToken());
    //     };
    // }
}
