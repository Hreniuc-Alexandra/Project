package com.lupascu.db.project.api;


import com.lupascu.db.project.payload.ApiResponse;
import com.lupascu.db.project.repository.DishRepository;
import com.lupascu.db.project.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestaurantController extends DBProjectController {
    private static final String API_NAME = "/restaurants";

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DishRepository dishRepository;

    @GetMapping(RestaurantController.API_NAME)
    public ResponseEntity<ApiResponse> getRestaurants() {
        return new ResponseEntity<>(new ApiResponse<>(null, restaurantService.getRestaurants()), HttpStatus.OK);
    }

    @GetMapping(RestaurantController.API_NAME + "/dishes")
    public ResponseEntity<ApiResponse> getRestaurantsbyid() {
        return new ResponseEntity<>(new ApiResponse<>(null, dishRepository.getAll()), HttpStatus.OK);
    }
}
