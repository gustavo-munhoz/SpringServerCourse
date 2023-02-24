package br.pucpr.maisrolev2.rest.users.personalData;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class PersonalData {
    @Id
    @GeneratedValue
    private Long id;
    private String cellNumber;

    private String firstName;

    private String lastName;
    private String dateOfBirth;
    @Column(unique = true)
    private String email;
}
