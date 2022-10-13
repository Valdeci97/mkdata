package com.mkdata.api.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String club;
  private String status;

  public Client() {
  }

  public Client(String name, String club, String status) {
    this.name = name;
    this.club = club;
    this.status = status;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setClub(String club) {
    this.club = club;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
