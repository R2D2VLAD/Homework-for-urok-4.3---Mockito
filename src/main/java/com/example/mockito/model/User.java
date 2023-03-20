package com.example.mockito.model;


import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Data
@Getter
public class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = correctName(name);
        this.surname = correctSurname(surname);
    }

    public String correctName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return name;
        }
    }

    public String correctSurname(String surname) {
        if (surname == null || surname.isEmpty() || surname.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return surname;
        }
    }
}
