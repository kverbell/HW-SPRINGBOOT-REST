package ru.netology.hwspringbootrest.repository;

import ru.netology.hwspringbootrest.model.Authorities;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if ("user1".equals(user) && "password1".equals(password)) {
            return List.of(Authorities.READ, Authorities.WRITE);
        } else if ("user2".equals(user) && "password2".equals(password)) {
            return List.of(Authorities.READ);
        } else {
            return new ArrayList<>();
        }
    }
}
