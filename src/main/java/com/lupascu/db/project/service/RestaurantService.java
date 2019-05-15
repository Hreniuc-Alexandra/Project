package com.lupascu.db.project.service;

import com.lupascu.db.project.payload.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
    public List<RestaurantDTO> getRestaurants();
}
