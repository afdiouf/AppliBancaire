package sn.dioufy.AppliBancaire.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.dioufy.AppliBancaire.model.Compte;
import sn.dioufy.AppliBancaire.model.CompteCourant;
import sn.dioufy.AppliBancaire.model.Operation;
import sn.dioufy.AppliBancaire.model.Retrait;
import sn.dioufy.AppliBancaire.model.Versement;
import sn.dioufy.AppliBancaire.repository.CompteRepository;
import sn.dioufy.AppliBancaire.repository.OperationRepository;

@Service
public class BanqueServiceImpl implements IBanqueService {
	
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String codeCpte) {
		// TODO Auto-generated method stub
		Optional<Compte> optional = compteRepository.findById(codeCpte);
		Compte compte = null;
		if (optional.isPresent()) {
			compte = optional.get();
		} else {
			throw new RuntimeException("Compte not found for id : " + codeCpte );
		}
		return compte;
	}

	@Override
	public void verser(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		Compte cp = consulterCompte(codeCpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		// TODO Auto-generated method stub
		Compte cp = consulterCompte(codeCpte);
		double facilitiesCaisse = 0;
		if (cp instanceof CompteCourant) {
			facilitiesCaisse = ((CompteCourant) cp).getDecouvert();
		}
		if (cp.getSolde()+facilitiesCaisse < montant) {
			throw new RuntimeException("Solde insuffisant");
		}
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double montant) {
		// TODO Auto-generated method stub
		if (codeCpte1.equals(codeCpte2)) {
			throw new RuntimeException("Virement impossible sur le meme compte");
		}
		retirer(codeCpte1, montant);
		verser(codeCpte2, montant);
	}

	@Override
	public List<Operation> listOperation(String codeCpte) {
		// TODO Auto-generated method stub
		List<Operation> listOp = operationRepository.listOperation(codeCpte);
		return listOp;
	}

	@Override
	public Iterable<Compte> getListCompte() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
	}

	@Override
	public void fermerCompte(String codeCompte) {
		// TODO Auto-generated method stub
		compteRepository.deleteById(codeCompte);
	}

}
