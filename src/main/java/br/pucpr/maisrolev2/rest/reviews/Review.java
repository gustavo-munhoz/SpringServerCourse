package br.pucpr.maisrolev2.rest.reviews;

import br.pucpr.maisrolev2.rest.hosts.Host;
import br.pucpr.maisrolev2.rest.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@NamedQuery(
        name="Review.findAllByUserId",
        query="SELECT r FROM Review r" +
                " JOIN r.user u" +
                " WHERE u = :id" +
                " ORDER BY r.id"
)
@NamedQuery(
        name="Review.findAllByHostId",
        query="SELECT r FROM Review r" +
                " JOIN r.host h" +
                " WHERE h = :id" +
                " ORDER BY r.id"
)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime postDate = LocalDateTime.now();
    @NotNull
    private Integer rating;
    private String text;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
