package com.example.mockito.dao.impl;

import com.example.mockito.dao.UserDao;
import com.example.mockito.exeptions.NoUserException;
import com.example.mockito.model.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class UserDaoImpl implements UserDao {
    private final List<User> users = new ArrayList<>();

    public UserDaoImpl() {
        users.add(new User("Vlad", "Zhitar"));
        users.add(new User("Viktor", "Beliakin"));
        users.add(new User("Maxim", "Gunicki"));
    }

    @Override
    public User getUserByName(String name, String surname) {
        for (User user : users) {
            if (user.getName().equals(name) && user.getSurname().equals(surname)) {
                return user;
            }
        }
        throw new NoUserException("No user!");
    }

        @Override
        public List<User> findAllUsers () {
            return users;
        }
    }
