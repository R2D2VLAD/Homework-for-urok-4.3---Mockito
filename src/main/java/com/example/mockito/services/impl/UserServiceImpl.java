package com.example.mockito.services.impl;

import com.example.mockito.dao.impl.UserDaoImpl;
import com.example.mockito.model.User;
import com.example.mockito.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao;

    @Override
    public boolean checkUserExist(User user) {
        if (userDao.getUsers().contains(user)) {
            return true;
        } else {
            return false;
        }
    }
}
