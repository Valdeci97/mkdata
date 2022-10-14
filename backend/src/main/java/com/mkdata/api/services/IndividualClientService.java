package com.mkdata.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.api.dto.IndividualClientDto;
import com.mkdata.api.exceptions.ClientNotFoundException;
import com.mkdata.api.models.Individual;
import com.mkdata.api.repositories.IndividualRepository;

@Service
public class IndividualClientService {
  @Autowired
  private IndividualRepository individualRepository;

  private final String clientNotFound = "Cliente não encontrado";

  public Individual updateIndividualClient(Long id, IndividualClientDto client) {
    Optional<Individual> dbClient = individualRepository.findById(id);
    if (dbClient.isEmpty()) {
      throw new ClientNotFoundException(this.clientNotFound);
    }
    Individual toUpdate = dbClient.get();
    toUpdate.setName(client.getName());
    toUpdate.setClub(client.getClub());
    toUpdate.setCpf(client.getCpf());
    toUpdate.setRg(client.getRg());
    toUpdate.setStatus(client.getStatus());
    Individual newClient = individualRepository.save(toUpdate);
    return newClient;
  }
}
