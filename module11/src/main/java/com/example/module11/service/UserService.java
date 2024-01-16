package com.example.module11.service;

import com.example.module11.entity.SberUser;
import com.example.module11.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SberUser createUser(SberUser sberUser){
        return userRepository.save(sberUser);
    }

    public List<SberUser> getUsers() {
        return userRepository.findAll();
    }

    public SberUser updateUser(SberUser user, Long id) {
        Optional<SberUser> oldUser = userRepository.findById(id);
        if (oldUser.isPresent()){
            SberUser updateUser = oldUser.get();
            updateUser.setName(user.getName());
            updateUser.setAge(user.getAge());
            return userRepository.save(updateUser);
        }else {
            throw new RuntimeException("User not find!");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
