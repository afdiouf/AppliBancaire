package sn.dioufy.AppliBancaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.dioufy.AppliBancaire.model.Compte;
import sn.dioufy.AppliBancaire.model.Operation;
import sn.dioufy.AppliBancaire.repository.OperationRepository;
import sn.dioufy.AppliBancaire.service.IBanqueService;

@RestController
@CrossOrigin("*")
public class BanqueController {

	@Autowired
	private IBanqueService banqueService;
	@Autowired
	private OperationRepository operationRepository;

	@GetMapping(value="/comptes")
	public Iterable<Compte> getAllComptes() {
		Iterable<Compte> listCompte = banqueService.getListCompte();
		return listCompte;
	}

	@GetMapping(value="/consulterCompte")
	public Compte consulter(@RequestParam() String codeCompte) {
		Compte compte = null;
		try {
			compte = banqueService.consulterCompte(codeCompte);
		} catch (Exception e) {
			throw new RuntimeException("Compte inexistant : ", e);
		}
		return compte;
	}
	
	@PostMapping(value="/saveOperation")
	public String saveOperation(Model model, @RequestParam() String typeOperation, @RequestParam() String codeCompte, @RequestParam() String codeCompte2, @RequestParam() double montant) {
		try {
			if (typeOperation.equals("VERS")) {
				banqueService.verser(codeCompte, montant);
			} else if (typeOperation.equals("RETR")) {
				banqueService.retirer(codeCompte, montant);
			} else {
				banqueService.virement(codeCompte, codeCompte2, montant);
			}
		} catch (Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
		}
		return "redirect:/consulterCompte?codeCompte="+codeCompte;
	}
	
	@PostMapping(value="/fermerCompte")
	public String fermerCompte(@RequestParam() String codeCompte) {
		banqueService.fermerCompte(codeCompte);
		String message = "Votre compte n° "+codeCompte+" a bien été supprimé";
		return "redirect:/home?message="+message;
	}
	
	@GetMapping(value="/listOperations")
	public List<Operation> listOperation(@RequestParam() String codeCompte){
		return operationRepository.listOperation(codeCompte);	
	}

}
