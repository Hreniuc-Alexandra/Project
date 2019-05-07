package com.lupascu.db.project.service;

import com.lupascu.db.project.model.Restaurant;
import com.lupascu.db.project.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public List<Restaurant> getRestaurants(){
        return restaurantRepository.getRestaurants();
    }
}
