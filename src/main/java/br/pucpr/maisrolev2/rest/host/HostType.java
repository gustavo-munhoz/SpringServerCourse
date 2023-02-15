package br.pucpr.maisrolev2.rest.host;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class HostType {
    @Id
    private Long id;

    private String type;

    @ManyToMany(mappedBy = "hostTypes")
    private Set<Host> hosts;

}
