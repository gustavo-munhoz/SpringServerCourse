package br.pucpr.maisrolev2;

import br.pucpr.maisrolev2.rest.host.Host;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    private Long id;

    private String stree;
    private String number;
    private String CEP;
    private String district;
    private String city;
    private String state;

    @OneToOne(mappedBy = "address")
    private Host host;
}
