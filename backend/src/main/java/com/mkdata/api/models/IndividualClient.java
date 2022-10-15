package com.mkdata.api.models;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class IndividualClient extends Client {
  private String cpf;
  private String rg;
  private LocalDate register_date;

  public IndividualClient() {
  }

  public IndividualClient(String name, String cpf, String rg, String club, String status, String type) {
    super(name, club, status, type);
    this.cpf = cpf;
    this.rg = rg;
    this.register_date = LocalDate.now();
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getRg() {
    return this.rg;
  }

  public LocalDate getRegisterDate() {
    return this.register_date;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public void setRegisterDate() {
    this.register_date = LocalDate.now();
  }
}
