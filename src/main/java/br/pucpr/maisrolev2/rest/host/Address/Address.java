package br.pucpr.maisrolev2.rest.host.Address;

import br.pucpr.maisrolev2.rest.host.Host;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @Data
public class Address {
    @Id
    private Long id;
    private String stree;
    private String number;
    private String CEP;
    private String district;
    private String city;
    private String state;

}
