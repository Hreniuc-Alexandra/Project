package com.lupascu.db.project.repository;

import com.lupascu.db.project.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "SELECT * FROM restaurants", nativeQuery = true)
    List<Restaurant> getAll();

    @Query(value = "SELECT menu_id FROM restaurants WHERE id=:restaurant_id", nativeQuery = true)
    Long getMenuId(@Param("restaurant_id") Long id);

    @Query(value = "SELECT image_url, name FROM restaurants WHERE id IN :ids", nativeQuery = true)
    List<String> getAttributesForGivenIds(@Param("ids") List<Long> ids);

    @Query(value = "SELECT image_url, name FROM restaurants WHERE id=:id", nativeQuery = true)
    String getAttributesForGivenId(@Param("id") Long id);

    @Query(value = "SELECT id FROM restaurants", nativeQuery = true)
    List<Long> getIds();

}
