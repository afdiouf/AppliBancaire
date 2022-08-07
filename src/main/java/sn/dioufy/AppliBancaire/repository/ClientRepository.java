package sn.dioufy.AppliBancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.dioufy.AppliBancaire.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
