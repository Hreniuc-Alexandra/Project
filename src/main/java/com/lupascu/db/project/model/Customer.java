package com.lupascu.db.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Column(unique = true)
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email address is invalid")
    private String email;
    @NotBlank
    @Column(unique = true)
    private String token;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer", orphanRemoval = true)
    private List<Purchase> orders = new ArrayList<>();

    public Customer(@NotBlank String firstName, @NotBlank String lastName, @NotBlank @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Email address is invalid") String email, @NotBlank String token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return  Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(token, customer.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, token);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Customer(String FirstName){
        this.firstName=FirstName;
    }
}
