package br.pucpr.maisrolev2.rest.users.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRequest {
    @Schema(
            example = "janedoe"
    )
    @NotBlank
    private String username;
    @Schema(
            example = "mYp@s$w0rd"
    )
    @NotBlank
    private String password;
}
