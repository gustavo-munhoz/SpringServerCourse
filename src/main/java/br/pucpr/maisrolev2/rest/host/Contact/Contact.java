package br.pucpr.maisrolev2.rest.host.Contact;

import br.pucpr.maisrolev2.rest.host.Host;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


@Entity @Data
public class Contact {
    @Id
    private Long id;
    private String insta;
    private String face;
    private String mobile;
    private String phone;
    private String email;

}
