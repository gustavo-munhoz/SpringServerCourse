package br.pucpr.maisrolev2.rest.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserPersonalData {
    @Id
    @GeneratedValue
    private Long id;
    private String cellNumber;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String dateOfBirth;
    @Column(unique = true, nullable = false)
    private String email;
}
