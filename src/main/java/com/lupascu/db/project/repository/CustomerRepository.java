package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT id FROM customer WHERE token=:token",nativeQuery = true)
    Long getCustomerIdFromToken(@Param("token") String token);

    @Query(value = "SELECT * FROM customer WHERE token=:token",nativeQuery = true)
    Optional<Customer> getCustomerByToken(@Param("token") String token);
}
