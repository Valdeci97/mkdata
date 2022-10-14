package com.mkdata.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.api.exceptions.ClientNotFoundException;
import com.mkdata.api.exceptions.CorporateClientAlreadyExistsException;
import com.mkdata.api.exceptions.IndividualClientAlreadyExistsException;
import com.mkdata.api.models.Client;
import com.mkdata.api.models.Corporate;
import com.mkdata.api.models.Individual;
import com.mkdata.api.repositories.ClientRepository;
import com.mkdata.api.repositories.CorporateRepository;
import com.mkdata.api.repositories.IndividualRepository;

@Service
public class ClientService {
  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private IndividualRepository individualRepository;

  @Autowired
  private CorporateRepository corporateRepository;

  private final String clientAlreadyExists = "Cliente já cadastrado";

  private final String clientNotFound = "Cliente não encontrado";

  /**
   * create an individual client
   * 
   * @param client
   * @return created client
   */
  public Individual createIndividualClient(Individual client) {
    String cpf = client.getCpf();
    if (individualRepository.cpfExists(cpf)) {
      throw new IndividualClientAlreadyExistsException(this.clientAlreadyExists);
    }
    Individual newClient = clientRepository.save(client);
    return newClient;
  }

  /**
   * create a corporate client
   * 
   * @param client
   * @return created client
   */
  public Corporate createCorporateClient(Corporate client) {
    String cnpj = client.getCnpj();
    if (corporateRepository.cnpjExists(cnpj)) {
      throw new CorporateClientAlreadyExistsException(this.clientAlreadyExists);
    }
    Corporate newClient = clientRepository.save(client);
    return newClient;
  }

  public List<Client> list() {
    List<Client> clients = clientRepository.findAll();
    return clients;
  }

  public Optional<Client> listById(Long id) {
    Optional<Client> client = clientRepository.findById(id);
    if (client.isEmpty()) {
      throw new ClientNotFoundException(this.clientNotFound);
    }
    return client;
  }

  public void delete(Long id) {
    Optional<Client> client = clientRepository.findById(id);
    if (client.isEmpty()) {
      throw new ClientNotFoundException(this.clientNotFound);
    }
    clientRepository.deleteById(id);
  }
}
