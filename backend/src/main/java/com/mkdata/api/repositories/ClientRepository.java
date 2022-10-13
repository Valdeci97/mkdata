package com.mkdata.api.repositories;

import com.mkdata.api.models.Client;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}