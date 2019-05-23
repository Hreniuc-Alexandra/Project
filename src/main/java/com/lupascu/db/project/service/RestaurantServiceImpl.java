package com.lupascu.db.project.service;

import com.lupascu.db.project.model.Dish;
import com.lupascu.db.project.model.Menu;
import com.lupascu.db.project.model.Restaurant;
import com.lupascu.db.project.payload.DishDTO;
import com.lupascu.db.project.payload.RestaurantDTO;
import com.lupascu.db.project.repository.DishRepository;
import com.lupascu.db.project.repository.MenuRepository;
import com.lupascu.db.project.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    @Transactional
    public List<RestaurantDTO> getRestaurants() {
        List<Long> restaurantIds = restaurantRepository.getIds();
        List<Restaurant> restaurants = restaurantIds.stream().parallel()
                .map(id -> {
                    String[] attrs = restaurantRepository.getAttributesForGivenId(id).split(",");
                    List<Dish> dishes = dishRepository.getByRestaurant(id).orElseGet(null);
                    Long menuId = restaurantRepository.getMenuId(id);
                    Double menuDiscount = menuRepository.getDiscount(menuId);
                    Menu m = new Menu();
                    m.setId(menuId);
                    m.setDiscountPercent(menuDiscount);
                    m.setDishes(dishes);
                    Restaurant r = new Restaurant();
                    r.setId(id);
                    r.setImageUrl(attrs[0]);
                    r.setName(attrs[1]);
                    r.setMenu(m);
                    return r;
                })
                .collect(Collectors.toList());
        return restaurants.stream().map(this::restaurantToDTO).collect(Collectors.toList());
    }

    private RestaurantDTO restaurantToDTO(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(restaurant.getId());
        restaurantDTO.setImagine(restaurant.getImageUrl());
        restaurantDTO.setDisplayMenu(true);
        restaurantDTO.setDiscount(restaurant.getMenu().getDiscountPercent());
        restaurantDTO.setNume(restaurant.getName());
        restaurantDTO.setMenu(menuToDTO(restaurant.getMenu()));
        return restaurantDTO;
    }

    private List<DishDTO> menuToDTO(Menu menu) {
        return menu.getDishes().stream().parallel().map(
                dish -> new DishDTO(
                        dish.getName(),
                        Double.parseDouble(String.format(Locale.US, "%.2f", dish.getCost() - dish.getCost() * (menu.getDiscountPercent() / 100))),
                        dish.getId())
        ).collect(Collectors.toList());
    }
}
