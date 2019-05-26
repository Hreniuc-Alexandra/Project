package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT id FROM customers WHERE token=:token", nativeQuery = true)
    Optional<Long> getCustomerIdFromToken(@Param("token") String token);

    @Query(value = "SELECT * FROM customers WHERE token=:token", nativeQuery = true)
    Optional<Customer> getCustomerByToken(@Param("token") String token);

    @Query(value = "SELECT * FROM customers WHERE email=:email", nativeQuery = true)
    Optional<Customer> getCustomerByEmail(@Param("email") String email);

    @Query(value = "SELECT max(id) FROM customers", nativeQuery = true)
    Long getLastId();

    @Modifying
    @Query(value= "UPDATE customers SET email='deleted', first_name='deleted', last_name='deleted', token='deleted' WHERE token=:token",nativeQuery = true)
    void deleteCustomerByToken(@Param("token") String token);

    @Modifying
    @Query(value = "INSERT INTO customers(email, first_name, last_name, token) values (:email, :first_name, :last_name, :token)", nativeQuery = true)
    Integer insertUser(@Param("email") String email, @Param("first_name") String firstName, @Param("last_name") String lastName, @Param("token") String token);
}
