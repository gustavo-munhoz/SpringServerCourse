package br.pucpr.maisrolev2.rest.users;

import br.pucpr.maisrolev2.rest.Role;
import br.pucpr.maisrolev2.rest.reviews.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    @Size(min = 5, max = 30)
    private String username;

    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]")
    private String password;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Role> roles = new HashSet<>();
    @OneToOne
    @NotNull
    private UserPersonalData personalData;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
}