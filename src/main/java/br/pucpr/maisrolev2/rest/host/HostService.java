package br.pucpr.maisrolev2.rest.host;

import org.springframework.stereotype.Service;

@Service
public class HostService {
    private HostRepository hostRepository;

    public HostService(HostRepository repository) {this.hostRepository = repository;}

    public Host add(Host host) {
        // colocar exeções
        return hostRepository.save(host);
    }
}
