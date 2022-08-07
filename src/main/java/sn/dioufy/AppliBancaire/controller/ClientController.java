package sn.dioufy.AppliBancaire.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sn.dioufy.AppliBancaire.model.Client;
import sn.dioufy.AppliBancaire.service.IClientService;

/**
 * @author afdio
 *
 */
@RestController
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@GetMapping(value = "/clients")
	public Iterable<Client> getAllClients() {
		return clientService.getAllClients();
	}

	@GetMapping(value = "/clients/{codeClient}")
	public Optional<Client> createClient(@PathVariable(name = "codeClient") Long codeClient) {
		return clientService.getClient(codeClient);
	}

	@PostMapping(value = "/clients")
	public Client createClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}

	@PutMapping(value = "/clients/{codeClient}")
	public Client updateClient(@PathVariable(name = "codeClient") final Long codeClient, @RequestBody Client client) {
		return clientService.updateClient(codeClient, client);
	}

	@DeleteMapping(value = "/clients/{codeClient}")
	public void deleteClient(@PathVariable(name = "codeClient") Long CodeClient) {
		clientService.deleteClient(CodeClient);
	}

}
