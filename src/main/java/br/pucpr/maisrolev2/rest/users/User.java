package br.pucpr.maisrolev2.rest.users;

import br.pucpr.maisrolev2.rest.Role;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private Set<Role> roles;
    private UserPersonalData personalData;
}