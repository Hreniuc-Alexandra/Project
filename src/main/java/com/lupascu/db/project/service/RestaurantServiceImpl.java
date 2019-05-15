package com.lupascu.db.project.service;

import com.lupascu.db.project.model.Menu;
import com.lupascu.db.project.model.Restaurant;
import com.lupascu.db.project.payload.DishDTO;
import com.lupascu.db.project.payload.RestaurantDTO;
import com.lupascu.db.project.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    @Transactional
    public List<RestaurantDTO> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.getAll();
        return restaurants.stream().map(this::restaurantToDTO).collect(Collectors.toList());
    }

    private RestaurantDTO restaurantToDTO(Restaurant restaurant){
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setImagine(restaurant.getImageUrl());
        restaurantDTO.setDisplayMenu(true);
        restaurantDTO.setNume(restaurant.getName());
        restaurantDTO.setMenu(menuToDTO(restaurant.getMenu()));
        return restaurantDTO;
    }

    private List<DishDTO> menuToDTO(Menu menu) {
        return menu.getDishes().stream().map(
                dish-> new DishDTO(
                        dish.getName(),
                        Double.parseDouble(String.format("%.2f",dish.getCost() - dish.getCost()*(menu.getDiscountPercent()/100))),
                        dish.getId())
        ).collect(Collectors.toList());
    }
}
