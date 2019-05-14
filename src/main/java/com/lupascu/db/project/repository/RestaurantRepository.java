package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "SELECT * FROM restaurants", nativeQuery = true)
    List<Restaurant> getAll();
}
