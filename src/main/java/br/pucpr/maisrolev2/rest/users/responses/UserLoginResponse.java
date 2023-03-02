package br.pucpr.maisrolev2.rest.users.responses;

import br.pucpr.maisrolev2.rest.users.User;
import lombok.Data;

@Data
public class UserLoginResponse {
    private String token;
    private String username;
    private String password;

    public UserLoginResponse(String token, User req) {
        this.token = token;
        this.username = req.getUsername();
        this.password = req.getPassword();
    }
}
