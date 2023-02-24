package br.pucpr.maisrolev2.rest.users.personalData;

import br.pucpr.maisrolev2.rest.users.personalData.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDataRepository extends JpaRepository<PersonalData, Long> {
}
