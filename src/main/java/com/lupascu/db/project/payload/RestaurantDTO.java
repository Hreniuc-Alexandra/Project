package com.lupascu.db.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {
    private Long id;
    private String imagine;
    private String nume;
    private Boolean displayMenu;
    private List<DishDTO> menu;
    private Double discount;
}
