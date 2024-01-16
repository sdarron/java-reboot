package com.example.module11;

import com.example.module11.controller.UserController;
import com.example.module11.entity.SberUser;
import com.example.module11.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class Module11ApplicationTests {

    @Test
    public void getUsers_whenNoUsersExist_shouldReturnEmptyList() throws Exception {
        UserController controller = new UserController(mock(UserService.class));
        List<SberUser> users = controller.getPeople();
        Assertions.assertEquals(0, users.size());
    }

    @Test
    public void getUsers_whenUsersExist_shouldReturnListOfUsers() throws Exception {
        List<SberUser> users = new ArrayList<>();
        users.add(new SberUser(1L,"John Doe", 30));
        users.add(new SberUser(2L, "Jane Doe", 25));
        UserService userService = mock(UserService.class);
        when(userService.getUsers()).thenReturn(users);
        UserController controller = new UserController(userService);
        List<SberUser> returnedUsers = controller.getPeople();
        Assertions.assertEquals(users, returnedUsers);
    }



}
