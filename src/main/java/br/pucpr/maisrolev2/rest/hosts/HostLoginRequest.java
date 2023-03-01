package br.pucpr.maisrolev2.rest.hosts;

import lombok.Data;

@Data
public class HostLoginRequest {
    private String email;
    private String password;
}
