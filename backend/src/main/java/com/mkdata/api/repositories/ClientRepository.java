package com.mkdata.api.repositories;

import com.mkdata.api.models.Client;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
  public List<Client> findByClub(String club);
}
