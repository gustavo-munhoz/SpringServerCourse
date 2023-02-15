package br.pucpr.maisrolev2.rest;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
}