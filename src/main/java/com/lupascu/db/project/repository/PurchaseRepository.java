package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    @Query(value= "SELECT * FROM purchase", nativeQuery = true)
    List<Purchase> getAllPurchases();

    @Query(value="SELECT * FROM purchase WHERE id=:id",nativeQuery = true)
    Purchase getPurchase(@Param("id") Long id);

    @Query(value = "SELECT * FROM purchase WHERE customer_id=:id",nativeQuery = true)
    List<Purchase> getPurchasesPerCustomer(@Param("id") Long id);
}
