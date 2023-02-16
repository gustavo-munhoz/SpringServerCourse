package br.pucpr.maisrolev2.rest.host.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;


    public Contact createContact(Contact contact) {
        return repository.save(contact);
    }
}
