package com.lupascu.db.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//
//public interface UserRepository extends JpaRepository<User,Long> {
//
//    @Query(value= "SELECT * FROM users", nativeQuery = true)
//    List<User> getUsers();
//
//
//      @Modifying
//      @Query(value="INSERT INTO role(id, name) values (:id, :name)", nativeQuery = true)
//      void insertUser(@Param("id")Long id,@Param("name") String name);
////}
