package br.pucpr.maisrolev2.rest.hosts.Address;

import jakarta.persistence.*;
import lombok.Data;


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
