package com.mkdata.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.api.exceptions.ClientAlreadyExistsException;
import com.mkdata.api.exceptions.ClientNotFoundException;
import com.mkdata.api.models.Client;
import com.mkdata.api.models.CorporateClient;
import com.mkdata.api.models.IndividualClient;
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
  public IndividualClient createIndividualClient(IndividualClient client) {
    String cpf = client.getCpf();
    if (individualRepository.existsByCpf(cpf)) {
      throw new ClientAlreadyExistsException(this.clientAlreadyExists);
    }
    client.setRegisterDate();
    IndividualClient newClient = clientRepository.save(client);
    return newClient;
  }

  /**
   * create a corporate client
   * 
   * @param client
   * @return created client
   */
  public CorporateClient createCorporateClient(CorporateClient client) {
    String cnpj = client.getCnpj();
    if (corporateRepository.existsByCnpj(cnpj)) {
      throw new ClientAlreadyExistsException(this.clientAlreadyExists);
    }
    client.setRegisterDate();
    CorporateClient newClient = clientRepository.save(client);
    return newClient;
  }

  public List<Client> list() {
    List<Client> clients = clientRepository.findAll();
    return clients;
  }

  public Client listById(Long id) {
    Optional<Client> client = clientRepository.findById(id);
    if (client.isEmpty()) {
      throw new ClientNotFoundException(this.clientNotFound);
    }
    return client.get();
  }

  public void delete(Long id) {
    Optional<Client> client = clientRepository.findById(id);
    if (client.isEmpty()) {
      throw new ClientNotFoundException(this.clientNotFound);
    }
    clientRepository.deleteById(id);
  }

  public List<Client> getByClub(String club) {
    List<Client> clients = clientRepository.findByClub(club);
    return clients;
  }
}
