package com.lupascu.db.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {

    @Nullable
    String email;
    @Nullable
    String firstName;
    @Nullable
    String lastName;
    @Nullable
    String token;

    @NotEmpty(message = "You can't order nothing")
    List<OrderItemDTO> orders;

}
