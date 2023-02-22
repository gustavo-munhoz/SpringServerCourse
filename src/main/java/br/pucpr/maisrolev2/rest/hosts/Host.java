package br.pucpr.maisrolev2.rest.hosts;

import br.pucpr.maisrolev2.rest.hosts.Address.Address;
import br.pucpr.maisrolev2.rest.hosts.Contact.Contact;
import br.pucpr.maisrolev2.rest.reviews.Review;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Host {
    @Id @GeneratedValue
    private Long id;
    private String password;

    @NotBlank
    private String hostName;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<HostType> hostTypes;

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private Contact contact;

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    //private Agenda agenda;
    //private Event event

}
