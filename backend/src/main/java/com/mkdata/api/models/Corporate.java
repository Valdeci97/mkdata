package com.mkdata.api.models;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("pj")
public class Corporate extends Client {
  private String cnpj;
  private String ie;
  private LocalDate register_date;

  public Corporate(String name, String cnpj, String ie, String club, String status) {
    super(name, club, status);
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
