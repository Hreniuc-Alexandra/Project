package com.lupascu.db.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    @NotNull
    Integer quantity;
    @NotNull
    Long dishId;

}
