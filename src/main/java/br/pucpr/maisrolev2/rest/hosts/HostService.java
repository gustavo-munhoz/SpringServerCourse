package br.pucpr.maisrolev2.rest.hosts;


import br.pucpr.maisrolev2.lib.exception.NotFoundException;
import br.pucpr.maisrolev2.rest.users.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {
    private final HostRepository hostRepository;


    public HostService(HostRepository repository) {this.hostRepository = repository;}

    public Host add(Host host) {
        return hostRepository.save(host);
    }

    public Host getHost(Long id) {return hostRepository.findHostById(id);}

    public List<Host> getAllHosts() {
        List<Host> hosts = hostRepository.findAll();
        if (hosts.isEmpty()) throw new NotFoundException("No hosts registered");
        return hosts;
    }
    /*
    public Host logHost(String email, String password) {
        var host = hostRepository.findHostByContact_Email(email);
    }
     */

}
