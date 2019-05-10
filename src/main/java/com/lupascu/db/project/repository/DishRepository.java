package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query(value = "SELECT * FROM dish WHERE id=:id", nativeQuery = true)
    Optional<Dish> getDishById(@Param("id") Long id);

    @Query(value = "SELECT * FROM dish WHERE name=:name", nativeQuery = true)
    Optional<Dish> getDishByName(@Param("name") String name);
}
