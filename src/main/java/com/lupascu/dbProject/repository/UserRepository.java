package com.lupascu.dbProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//
//public interface UserRepository extends JpaRepository<User,Long> {
//
//    @Query(value= "SELECT * FROM users", nativeQuery = true)
//    List<User> getUsers();
//
//    @Modifying
//    @Query(value="INSERT INTO user(name, password) values (:name, :password)", nativeQuery = true)
//    void insertUser(String name, String password);
//}
