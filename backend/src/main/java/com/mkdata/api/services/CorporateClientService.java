package com.mkdata.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.api.exceptions.ClientNotFoundException;
import com.mkdata.api.models.Corporate;
import com.mkdata.api.repositories.CorporateRepository;

@Service
public class CorporateClientService {
  @Autowired
  private CorporateRepository corporateRepository;

  private final String clientNotFound = "Cliente não encontrado";

  public Corporate updateIndividualClient(Long id, Corporate client) {
    Optional<Corporate> dbClient = corporateRepository.findById(id);
    if (dbClient.isEmpty()) {
      throw new ClientNotFoundException(this.clientNotFound);
    }
    Corporate toUpdate = dbClient.get();
    toUpdate.setName(client.getName());
    toUpdate.setClub(client.getClub());
    toUpdate.setCnpj(client.getCnpj());
    toUpdate.setIe(client.getIe());
    toUpdate.setStatus(client.getStatus());
    Corporate newClient = corporateRepository.save(toUpdate);
    return newClient;
  }
}
