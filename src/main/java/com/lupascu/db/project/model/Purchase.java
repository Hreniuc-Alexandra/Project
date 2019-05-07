package com.lupascu.db.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Ordering;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    private Instant date;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "purchase", orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
}
