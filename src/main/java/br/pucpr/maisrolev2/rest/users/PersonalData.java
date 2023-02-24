package br.pucpr.maisrolev2.rest.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
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
