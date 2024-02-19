package ru.edu.module13.repository;

import ru.edu.module13.entity.SberUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <SberUser, Long> {

}
