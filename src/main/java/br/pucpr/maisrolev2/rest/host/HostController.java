package br.pucpr.maisrolev2.rest.host;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hosts")
public class HostController {
    private final HostService service;

    public HostController(HostService service) {this.service = service;}
    @PostMapping
    @Transactional
    public Host add(@Valid @RequestBody Host host) {
        return service.add(host);
    }

}
