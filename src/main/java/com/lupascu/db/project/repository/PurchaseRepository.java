package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query(value = "SELECT * FROM purchase", nativeQuery = true)
    List<Purchase> getAllPurchases();

    @Query(value = "SELECT * FROM purchase WHERE id=:id", nativeQuery = true)
    Purchase getPurchase(@Param("id") Long id);

    @Query(value = "SELECT * FROM purchase WHERE customer_id=:id", nativeQuery = true)
    Optional<List<Purchase>> getPurchasesPerCustomer(@Param("id") Long id);

    @Query(value = "SELECT max(id) FROM purchase", nativeQuery = true)
    Long getLastId();

    @Modifying
    @Query(value = "UPDATE purchase SET customer_id=null WHERE customer_id=:customer_id", nativeQuery = true)
    void preparePurchaseForCustomerDeletion(@Param("customer_id") Long customer_id);

    @Modifying
    @Query(value = "INSERT INTO purchase(date, customer_id, extra_fees) values (now(), :customer_id, :extra_fees)", nativeQuery = true)
    Integer insertPurchase(@Param("customer_id") Long customer_id, @Param("extra_fees") Double extra_fees);
}
