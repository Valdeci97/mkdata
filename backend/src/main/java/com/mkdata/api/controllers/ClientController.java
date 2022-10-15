package com.mkdata.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkdata.api.exceptions.CorporateClientAlreadyExistsException;
import com.mkdata.api.exceptions.IndividualClientAlreadyExistsException;
import com.mkdata.api.models.Client;
import com.mkdata.api.models.Corporate;
import com.mkdata.api.models.Individual;
import com.mkdata.api.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
  @Autowired
  private ClientService clientService;

  @PostMapping("/pf")
  public ResponseEntity<Individual> createIndividualClient(
      @RequestBody Individual client) throws IndividualClientAlreadyExistsException {
    Individual newClient = clientService.createIndividualClient(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
  }

  @PostMapping("/pj")
  public ResponseEntity<Corporate> createCorporateClient(
      @RequestBody Corporate client) throws CorporateClientAlreadyExistsException {
    Corporate newClient = clientService.createCorporateClient(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
  }

  @GetMapping
  public ResponseEntity<List<Client>> list() {
    List<Client> clients = clientService.list();
    return ResponseEntity.status(HttpStatus.OK).body(clients);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> listById(@RequestParam("id") Long id) {
    Client client = clientService.listById(id);
    return ResponseEntity.status(HttpStatus.OK).body(client);
  }

  @DeleteMapping("/{id}")
  public void delete(@RequestParam("id") Long id) {
    clientService.delete(id);
  }
}
