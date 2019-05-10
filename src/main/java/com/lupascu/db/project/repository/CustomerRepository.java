package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT id FROM customer WHERE token=:token",nativeQuery = true)
    Optional<Long> getCustomerIdFromToken(@Param("token") String token);

    @Query(value = "SELECT * FROM customer WHERE token=:token",nativeQuery = true)
    Optional<Customer> getCustomerByToken(@Param("token") String token);

    @Modifying
    @Query(value="INSERT INTO customer(email, first_name, last_name, token) values (:email, :first_name, :last_name, :token)", nativeQuery = true)
    Customer insertUser(@Param("email")String email,@Param("first_name") String first_name, @Param("last_name") String last_name, @Param("token") String token);
}
