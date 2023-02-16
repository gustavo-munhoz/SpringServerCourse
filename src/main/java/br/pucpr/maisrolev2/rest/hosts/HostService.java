package br.pucpr.maisrolev2.rest.hosts;

import br.pucpr.maisrolev2.rest.hosts.Address.Address;
import br.pucpr.maisrolev2.rest.hosts.Address.AddressService;
import br.pucpr.maisrolev2.rest.hosts.Contact.Contact;
import br.pucpr.maisrolev2.rest.hosts.Contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HostService {

    private final HostRepository hostRepository;

    @Autowired
    private ContactService contactService;
    private AddressService addressService;

    public HostService(HostRepository repository) {this.hostRepository = repository;}

    public Host add(Host host) {
        Contact contact = host.getContact();
        Address address = host.getAddress();
        addressService.addAddress(address);
        contactService.createContact(contact);
        return hostRepository.save(host);
    }
}
