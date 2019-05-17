package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query(value = "SELECT discount_percent FROM menus WHERE id=:menu_id", nativeQuery = true)
    Double getDiscount(@Param("menu_id") Long id);
}
