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

import com.mkdata.api.dto.CorporateClientDto;
import com.mkdata.api.exceptions.ClientAlreadyExistsException;
import com.mkdata.api.exceptions.ClientNotFoundException;
import com.mkdata.api.models.CorporateClient;
import com.mkdata.api.services.ClientService;
import com.mkdata.api.services.CorporateClientService;

@RestController
@RequestMapping("/clients/pj")
public class CorporateClientController {
  @Autowired
  private ClientService clientService;

  @Autowired
  private CorporateClientService corporateClientService;

  @PostMapping
  public ResponseEntity<CorporateClient> create(
      @RequestBody CorporateClient client) throws ClientAlreadyExistsException {
    CorporateClient newClient = clientService.createCorporateClient(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
  }

  @PutMapping
  public ResponseEntity<CorporateClient> update(
      @RequestParam("id") Long id,
      @RequestBody CorporateClientDto client) throws ClientNotFoundException {
    CorporateClient updatedClient = corporateClientService.update(id, client);
    return ResponseEntity.status(HttpStatus.OK).body(updatedClient);
  }
}