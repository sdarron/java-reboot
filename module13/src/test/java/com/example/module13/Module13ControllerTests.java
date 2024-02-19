package com.example.module13;

import ru.edu.module13.controller.UserController;
import ru.edu.module13.entity.SberUser;
import ru.edu.module13.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class Module13ControllerTests {

    @Test
    public void getUsers_whenNoUsersExist_shouldReturnEmptyList() throws Exception {
        UserController controller = new UserController(mock(UserService.class));
        List<SberUser> users = controller.getPeople();
        Assertions.assertEquals(0, users.size());
    }

    @Test
    public void getUsers_whenUsersExist_shouldReturnListOfUsers() throws Exception {
        List<SberUser> users = new ArrayList<>();
        users.add(new SberUser(1L,"Denis", 34));
        users.add(new SberUser(2L, "Ivan", 40));
        UserService userService = mock(UserService.class);
        when(userService.getUsers()).thenReturn(users);
        UserController controller = new UserController(userService);
        List<SberUser> returnedUsers = controller.getPeople();
        Assertions.assertEquals(users, returnedUsers);
    }


    @Test
    public void addUser_whenUserIsValid_shouldAddUser() throws Exception {
        SberUser user = new SberUser(1L,"Petr", 30);
        UserService userService = mock(UserService.class);
        when(userService.createUser(user)).thenReturn(user);
        UserController controller = new UserController(userService);
        SberUser userSave = controller.createUser(user);
        Assertions.assertEquals(userSave, user);
    }

    @Test
    public void deleteUser_whenUserExists_shouldDeleteUser() throws Exception {
        SberUser user = new SberUser(1L,"Ivan", 30);
        UserService userService = mock(UserService.class);
        UserController controller = new UserController(userService);
        userService.createUser(user);
        controller.deleteUser(1L);
        List<SberUser> users = controller.getPeople();
        Assertions.assertEquals(true, users.isEmpty());
    }

}
