package br.pucpr.maisrolev2.rest.hosts;

import br.pucpr.maisrolev2.rest.Role;
import br.pucpr.maisrolev2.rest.hosts.Address.Address;
import br.pucpr.maisrolev2.rest.hosts.Contact.Contact;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Role> roles;


    //private Agenda agenda;
    //private Event event

}
