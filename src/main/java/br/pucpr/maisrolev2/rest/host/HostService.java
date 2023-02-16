package br.pucpr.maisrolev2.rest.host;

import br.pucpr.maisrolev2.rest.host.Address.Address;
import br.pucpr.maisrolev2.rest.host.Address.AddressService;
import br.pucpr.maisrolev2.rest.host.Contact.Contact;
import br.pucpr.maisrolev2.rest.host.Contact.ContactService;
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
