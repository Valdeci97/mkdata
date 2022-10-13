package com.mkdata.api.models;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("pf")
public class Individual extends Client {
  private String cpf;
  private String rg;
  private LocalDate register_date;

  public Individual() {
  }

  public Individual(String name, String cpf, String rg, String club, String status) {
    super(name, club, status);
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

  public LocalDate getRegisteDate() {
    return this.register_date;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }
}
