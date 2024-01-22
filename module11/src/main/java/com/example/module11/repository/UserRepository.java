package com.example.module11.repository;

import com.example.module11.entity.SberUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <SberUser, Long> {

}
