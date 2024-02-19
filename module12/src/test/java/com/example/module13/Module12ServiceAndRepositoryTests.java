package com.example.module13;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.edu.module13.entity.SberUser;
import ru.edu.module13.repository.UserRepository;
import ru.edu.module13.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Module12ServiceAndRepositoryTests {
    @Mock
    private UserRepository repository;

    private UserService service;

    @BeforeEach
    void setUp() {
        service = new UserService(repository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        ArrayList users = new ArrayList<>(Arrays.asList( new SberUser(1L, "Ivan", 20),
                                                         new SberUser(2L, "Denis", 39)));
        when(repository.findAll()).thenReturn(users);
        List<SberUser> allUsers = service.getUsers();
        assertThat(allUsers.size()).isGreaterThan(0);
    }

    @Test
    void save() {
        SberUser user = new SberUser(1L, "Ira", 18);

        when(repository.save(user)).thenReturn(user);
        SberUser createdUser = service.createUser(user);
        assertThat(createdUser.getName()).isNotNull();
    }

}
