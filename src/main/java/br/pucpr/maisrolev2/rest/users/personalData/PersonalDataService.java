package br.pucpr.maisrolev2.rest.users.personalData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalDataService {

    @Autowired
    private PersonalDataRepository dataRepository;

    public PersonalData addPersonalData(PersonalData personalData) {return  dataRepository.save(personalData);}
}
