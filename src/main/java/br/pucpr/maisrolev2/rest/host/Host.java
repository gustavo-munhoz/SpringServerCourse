package br.pucpr.maisrolev2.rest.host;

import br.pucpr.maisrolev2.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Host {

    @Id
    @GeneratedValue
    private Long id;
    private String password;

    @NotBlank
    private String hostName;
    @ManyToMany
    @Cascade(CascadeType.ALL)
    @JoinTable(name = "Host_HostType",
            joinColumns = @JoinColumn(name = "host_id"),
            inverseJoinColumns = @JoinColumn(name = "hostType_id"))
    private Set<HostType> hostTypes;

    /**
    private Contact contact;
    private Agenda agenda;
    */

    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private Address address;

}
