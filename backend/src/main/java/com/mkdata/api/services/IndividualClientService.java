package com.mkdata.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.api.dto.IndividualClientDto;
import com.mkdata.api.exceptions.ClientNotFoundException;
import com.mkdata.api.models.IndividualClient;
import com.mkdata.api.repositories.IndividualRepository;

@Service
public class IndividualClientService {
  @Autowired
  private IndividualRepository individualRepository;

  private final String clientNotFound = "Cliente não encontrado";

  public IndividualClient update(Long id, IndividualClientDto client) {
    Optional<IndividualClient> dbClient = individualRepository.findById(id);
    if (dbClient.isEmpty()) {
      throw new ClientNotFoundException(this.clientNotFound);
    }
    IndividualClient toUpdate = dbClient.get();
    toUpdate.setName(client.getName());
    toUpdate.setClub(client.getClub());
    toUpdate.setCpf(client.getCpf());
    toUpdate.setRg(client.getRg());
    toUpdate.setStatus(client.getStatus());
    IndividualClient newClient = individualRepository.save(toUpdate);
    return newClient;
  }
}
