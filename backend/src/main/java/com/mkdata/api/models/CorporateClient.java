package com.mkdata.api.models;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class CorporateClient extends Client {
  private String cnpj;
  private String ie;
  private LocalDate register_date;

  public CorporateClient(String name, String cnpj, String ie, String club, String status, String type) {
    super(name, club, status, type);
    this.cnpj = cnpj;
    this.ie = ie;
    this.register_date = LocalDate.now();
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public String getIe() {
    return this.ie;
  }

  public LocalDate getRegisteDate() {
    return this.register_date;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public void setIe(String ie) {
    this.ie = ie;
  }
}
