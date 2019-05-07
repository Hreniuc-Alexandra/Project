package com.lupascu.db.project.api;


import com.lupascu.db.project.model.Restaurant;
import com.lupascu.db.project.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController extends DBProjectController{
    public static final String API_NAME="/restaurants";

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(RestaurantController.API_NAME)
    public List<Restaurant> GetRestaurants(){
        return restaurantService.getRestaurants();
    }
}
