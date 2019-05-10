package com.lupascu.db.project.payload;

import com.lupascu.db.project.exceptions.CredentialException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

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

    List<OrderItemDTO> orders;

}
