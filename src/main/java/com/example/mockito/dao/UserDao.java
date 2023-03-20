package com.example.mockito.dao;

import com.example.mockito.model.User;

import java.util.List;

public interface UserDao {

    User getUserByName(String name, String surname);

    List<User> findAllUsers();
}
