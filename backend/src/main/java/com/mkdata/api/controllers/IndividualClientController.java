package com.mkdata.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkdata.api.dto.IndividualClientDto;
import com.mkdata.api.exceptions.ClientAlreadyExistsException;
import com.mkdata.api.exceptions.ClientNotFoundException;
import com.mkdata.api.models.IndividualClient;
import com.mkdata.api.services.ClientService;
import com.mkdata.api.services.IndividualClientService;

@RestController
@RequestMapping("/clients/pf")
public class IndividualClientController {
  @Autowired
  private ClientService clientService;

  @Autowired
  IndividualClientService individualClientService;

  @PostMapping
  public ResponseEntity<IndividualClient> create(
      @RequestBody IndividualClient client) throws ClientAlreadyExistsException {
    IndividualClient newClient = clientService.createIndividualClient(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
  }

  @PutMapping
  public ResponseEntity<IndividualClient> update(
      @RequestParam("id") Long id,
      @RequestBody IndividualClientDto client) throws ClientNotFoundException {
    IndividualClient updatedClient = individualClientService.update(id, client);
    return ResponseEntity.status(HttpStatus.OK).body(updatedClient);
  }
}
