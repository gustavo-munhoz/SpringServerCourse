package br.pucpr.maisrolev2.rest.hosts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
    Host findHostById(Long id);
    Host findHostByContact_Email(String email);
}
