package ru.netology.hwspringbootrest.controller;

import ru.netology.hwspringbootrest.exception.InvalidCredentials;
import ru.netology.hwspringbootrest.exception.UnauthorizedUser;
import ru.netology.hwspringbootrest.model.Authorities;
import ru.netology.hwspringbootrest.service.AuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentials(InvalidCredentials ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUnauthorizedUser(UnauthorizedUser ex) {
        System.out.println("Unauthorized access attempt: " + ex.getMessage());
        return ex.getMessage();
    }
}
