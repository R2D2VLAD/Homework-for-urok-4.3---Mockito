package com.example.mockito.dao.impl;

import com.example.mockito.exeptions.NoUserException;
import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserDaoImplTest {
    private static final String TRUE_USER_NAME1 = "Vlad";
    private static final String TRUE_USER_SURNAME1 = "Zhitar";
    private static final String FALSE_USER_NAME = "Вера";
    private static final String FALSE_USER_SURNAME = "Конышева";
    UserDaoImpl userDao;

    @Test
    void shouldReturnAnExistingUser() {
        userDao = new UserDaoImpl();
        Assertions.assertEquals(new User(TRUE_USER_NAME1, TRUE_USER_SURNAME1),
                userDao.getUserByName(TRUE_USER_NAME1, TRUE_USER_SURNAME1));
    }

    @Test
    void shouldReturnAnErrorWhenTheUserIsNotFound() {
        userDao = new UserDaoImpl();
        Assertions.assertThrows(NoUserException.class,
                () -> userDao.getUserByName(FALSE_USER_NAME, FALSE_USER_SURNAME));
    }
}