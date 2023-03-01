package br.pucpr.maisrolev2.rest.users;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class UserPersonalData {
    @Id
    @GeneratedValue
    @Schema(hidden = true)
    private Long id;
    @Schema(
        description = "Cellphone number of user",
        example = "(41) 92142-9431"
    )
    private String cellNumber;
    @NotBlank
    @Schema(
        description = "First name of user",
        example = "John"
    )
    private String firstName;
    @NotBlank
    @Schema(
            description = "Last name of user",
            example = "Doe"
    )
    private String lastName;
    @Schema(
            description = "Date of birth of user",
            example = "20/10/1992"
    )
    private String dateOfBirth;
    @Column(unique = true, nullable = false)
    @Schema(
            description = "Email of user",
            example = "johndoe@email.com"
    )
    private String email;
}
