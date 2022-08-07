package sn.dioufy.AppliBancaire.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.dioufy.AppliBancaire.model.Client;
import sn.dioufy.AppliBancaire.repository.ClientRepository;

/**
 * @author afdio
 *
 */
@Service
public class ClientServiceImpl implements IClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Optional<Client> getClient(Long codeClient) {
		// TODO Auto-generated method stub
		Optional<Client> optionalClient = clientRepository.findById(codeClient);
		if (optionalClient.isPresent()) {
			return optionalClient;
		} else {
			return null;
		}
	}

	@Override
	public Iterable<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public void deleteClient(Long codeClient) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(codeClient);
	}

	@Override
	public Client saveClient(Client client) {
		// TODO Auto-generated method stub
		Client savedClient = clientRepository.save(client);
		return savedClient;
	}
	
	public Client updateClient(Long codeClient, Client client) {
		Optional<Client> c = clientRepository.findById(codeClient);
		if (c.isPresent()) {
			Client currentClient = c.get();
			String nom = client.getNom();
			if (nom != null) {
				currentClient.setNom(nom);
			}
			String email = client.getEmail();
			if (email != null) {
				currentClient.setEmail(email);
			}
			String password = client.getPassword();
			if (password != null) {
				currentClient.setPassword(password);
			}
			clientRepository.save(currentClient);
			return currentClient;
		} else {
			return null;
		}
	}

}
