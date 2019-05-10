package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    @Modifying
    @Query(value="INSERT INTO order_item(quantity,dish_id,purchase_id) values (:quantity,:dish_id,:purchase_id)", nativeQuery = true)
    void insertOrder(@Param("quantity") Integer quantity, @Param("dish_id") Long dish_id, @Param("purchase_id") Long purchase_id);
}
