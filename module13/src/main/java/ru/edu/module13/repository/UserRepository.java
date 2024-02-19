package ru.edu.module13.repository;

import org.springframework.stereotype.Repository;
import ru.edu.module13.entity.SberUser;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository <SberUser, Long> {

}
