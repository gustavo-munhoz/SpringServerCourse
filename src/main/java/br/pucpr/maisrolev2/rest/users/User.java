package br.pucpr.maisrolev2.rest.users;

import br.pucpr.maisrolev2.rest.Role;
import br.pucpr.maisrolev2.rest.reviews.Review;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(
    name = "User.findByUsername",
    query = "select u " +
            "from User u " +
            "where upper(u.username) " +
            "like upper(:username)"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private Set<Role> roles;
    @OneToOne
    @NotNull
    private UserPersonalData personalData;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>();
}