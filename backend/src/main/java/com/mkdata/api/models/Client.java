package com.mkdata.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String club;
  private String status;
  private String type;

  public Client() {
  }

  public Client(String name, String club, String status, String type) {
    this.name = name;
    this.club = club;
    this.status = status;
    this.type = type;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getClub() {
    return this.club;
  }

  public String getStatus() {
    return this.status;
  }

  public String getType() {
    return this.type;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setClub(String club) {
    this.club = club;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setType(String type) {
    this.type = type;
  }
}
