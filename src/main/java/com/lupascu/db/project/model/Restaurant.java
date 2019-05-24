package com.lupascu.db.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @NotBlank
    private String name;
    @OneToOne(targetEntity = Menu.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "menu_id")
    private Menu menu;

    @NotBlank
    private String imageUrl;
}