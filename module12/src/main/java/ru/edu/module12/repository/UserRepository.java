package ru.edu.module12.repository;

import ru.edu.module12.entity.SberUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <SberUser, Long> {

}
