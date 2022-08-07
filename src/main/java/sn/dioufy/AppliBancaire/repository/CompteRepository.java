package sn.dioufy.AppliBancaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.dioufy.AppliBancaire.model.Compte;


@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {

}
