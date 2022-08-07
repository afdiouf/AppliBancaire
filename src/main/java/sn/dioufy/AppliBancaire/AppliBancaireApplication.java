package sn.dioufy.AppliBancaire;

//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import sn.dioufy.AppliBancaire.model.Client;
import sn.dioufy.AppliBancaire.model.Compte;
import sn.dioufy.AppliBancaire.model.CompteCourant;
import sn.dioufy.AppliBancaire.model.CompteEpargne;
import sn.dioufy.AppliBancaire.model.Retrait;
import sn.dioufy.AppliBancaire.model.Versement;
import sn.dioufy.AppliBancaire.repository.ClientRepository;
import sn.dioufy.AppliBancaire.repository.CompteRepository;
import sn.dioufy.AppliBancaire.repository.OperationRepository;
import sn.dioufy.AppliBancaire.service.IBanqueService;*/

@SpringBootApplication
public class AppliBancaireApplication /* implements CommandLineRunner */ {

//	@Autowired
//	private ClientRepository clientRepository;
//	@Autowired
//	private CompteRepository compteRepository;
//	@Autowired
//	private OperationRepository operationRepository;
//	@Autowired
//	private IBanqueService banqueService;

	public static void main(String[] args) {
		SpringApplication.run(AppliBancaireApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception { // TODO
	 * Auto-generated method stub
	 * 
	 * Client c1 = clientRepository.save(new Client("Al Hamdou Fassar DIOUF",
	 * "afdiouf@gmail.com")); Client c2 = clientRepository.save(new
	 * Client("Mouhamed Naby Ndiaye", "ndiaye@gmail.com"));
	 * 
	 * Compte cp1 = compteRepository.save(new CompteCourant("c1", new Date(), 90000,
	 * c1, 6000)); Compte cp2 = compteRepository.save(new CompteEpargne("c2", new
	 * Date(), 6000, c2, 5.5));
	 * 
	 * operationRepository.save(new Versement(new Date(), 9000, cp1));
	 * operationRepository.save(new Versement(new Date(), 6000, cp1));
	 * operationRepository.save(new Versement(new Date(), 2300, cp1));
	 * operationRepository.save(new Retrait(new Date(), 9000, cp1));
	 * 
	 * operationRepository.save(new Versement(new Date(), 2300, cp2));
	 * operationRepository.save(new Versement(new Date(), 400, cp2));
	 * operationRepository.save(new Versement(new Date(), 2300, cp2));
	 * operationRepository.save(new Retrait(new Date(), 3000, cp2));
	 * 
	 * banqueService.verser("c1", 111111);
	 * 
	 * }
	 */

}
