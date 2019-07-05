package com.example.naillashes.repository;

import com.example.naillashes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);

    List<User> findByIdIn(List<Long> userIds);

  //  User findByUsername(String username);

 //   Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}


