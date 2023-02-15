package br.pucpr.maisrolev2.rest.users;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

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
    private String email;
}
