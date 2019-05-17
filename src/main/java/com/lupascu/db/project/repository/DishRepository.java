package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query(value = "SELECT * FROM dishes WHERE id=:id", nativeQuery = true)
    Optional<Dish> getDishById(@Param("id") Long id);

    @Query(value = "SELECT * FROM dishes WHERE name=:name", nativeQuery = true)
    Optional<Dish> getDishByName(@Param("name") String name);

    @Query(value = "SELECT * FROM dishes", nativeQuery = true)
    Optional<List<Dish>> getAll();

    @Query(value = "SELECT * FROM dishes WHERE menu_id = SELECT menu_id FROM restaurants WHERE id=:restaurant_id", nativeQuery = true)
    Optional<List<Dish>> getByRestaurant(@Param("restaurant_id") Long restaurantId);
}
