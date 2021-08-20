package com.example.springredditclone.repository;

import java.util.Optional;

import com.example.springredditclone.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

}
