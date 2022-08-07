package sn.dioufy.AppliBancaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sn.dioufy.AppliBancaire.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	
	@Query("Select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
	public List<Operation> listOperation(@Param("x") String codeCpte);

}
