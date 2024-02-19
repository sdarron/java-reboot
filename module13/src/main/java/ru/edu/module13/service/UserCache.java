package ru.edu.module13.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserCache {
    private Map<String,UserInfo> cache = new HashMap<>();

    public UserInfo get(String id) {
        return cache.get(id);
    }
    private void create(UserInfo info) {
        cache.put(info.getLogin(), info);
    }

    @PostConstruct
    public void init() {
        create(new UserInfo("admin", "123456", "Ivan Ivanov", "ADMIN"));
        create(new UserInfo("petr", "qwerty", "Pert Petrov", "USER"));
    }

}
