package br.pucpr.maisrolev2.rest.users.personalData;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personalData")
public class PersonalDataController {

    @Autowired
    private PersonalDataService personalDataService;

    @PostMapping
    @Transactional
    public PersonalData add(@Valid @RequestBody PersonalData personalData) {return personalDataService.addPersonalData(personalData);}
}
