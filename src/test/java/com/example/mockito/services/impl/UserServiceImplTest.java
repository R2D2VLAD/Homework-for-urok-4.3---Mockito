package com.example.mockito.services.impl;

import com.example.mockito.dao.impl.UserDaoImpl;
import com.example.mockito.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private static final String TRUE_USER_NAME1 = "Vlad";
    private static final String TRUE_USER_SURNAME1 = "Zhitar";
    private static final String TRUE_USER_NAME2 = "Viktor";
    private static final String TRUE_USER_SURNAME2 = "Beliakin";
    private static final String TRUE_USER_NAME3 = "Maxim";
    private static final String TRUE_USER_SURNAME3 = "Gunicki";
    private static final String FALSE_USER_NAME = "Вера";
    private static final String FALSE_USER_SURNAME = "Конышева";
    private static final List<User> users = new ArrayList<>(Arrays.asList(
            new User(TRUE_USER_NAME1, TRUE_USER_SURNAME1),
            new User(TRUE_USER_NAME2, TRUE_USER_SURNAME2),
            new User(TRUE_USER_NAME3, TRUE_USER_SURNAME3)));
    @Mock
    UserDaoImpl mock;
    @InjectMocks
    UserServiceImpl out;

    @Test
    void shouldReturnTheValueTrue() {
        when(mock.getUsers()).thenReturn(users);
        Assertions.assertTrue(out.checkUserExist(users.get(0)));
    }

    @Test
    void shouldReturnTheValueFalse() {
        when(mock.getUsers()).thenReturn(users);
        Assertions.assertFalse(out.checkUserExist(new User(FALSE_USER_NAME, FALSE_USER_SURNAME)));
    }
}