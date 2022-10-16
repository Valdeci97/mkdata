package com.mkdata.api.controllers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mkdata.api.models.IndividualClient;
import com.mkdata.api.services.ClientService;

@DisplayName("Client Controller tests")
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
  @MockBean
  private ClientService clientService;

  @Autowired
  private MockMvc mockMvc;

  private final String PATH = "/clients";

  private IndividualClient client;

  @Test
  @DisplayName("Must be able to create an individual client")
  public void createIndividualClientTest() throws Exception {
    this.client = new IndividualClient(
        "cliente teste", "99999999999", "999999999", "teste", "ativo", "pf");
    ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
    String json = mapper.writeValueAsString(client);
    mockMvc
        .perform(MockMvcRequestBuilders.post(this.PATH + "/pf").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isCreated());
    verify(clientService, times(1)).createIndividualClient(this.client);
  }
}
