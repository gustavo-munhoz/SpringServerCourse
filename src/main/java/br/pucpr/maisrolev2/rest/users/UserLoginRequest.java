package br.pucpr.maisrolev2.rest.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserLoginRequest {
    @Schema(
            example = "janedoe"
    )
    private String username;
    @Schema(
            example = "mYp@s$w0rd"
    )
    private String password;
}
