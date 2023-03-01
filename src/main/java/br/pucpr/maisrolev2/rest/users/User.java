package br.pucpr.maisrolev2.rest.users;

import br.pucpr.maisrolev2.rest.Role;
import br.pucpr.maisrolev2.rest.reviews.Review;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @Schema(hidden = true)
    private Long id;
    @Column(unique = true, nullable = false)
    @Size(min = 5, max = 30)
    @Schema(
            description = "Username of account",
            example = "johndoe",
            type = "string"
    )
    private String username;

    @Size(min = 8, max = 40)
    @Schema(
            description = "Password of account",
            example = "mYp@s$w0rd",
            type = "string"
    )
    private String password;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @Schema(hidden = true)
    private Set<Role> roles = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private UserPersonalData personalData;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Schema(hidden = true)
    private Set<Review> reviews = new HashSet<>();
}