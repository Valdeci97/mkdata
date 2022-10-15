package com.mkdata.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkdata.api.models.IndividualClient;

@Repository
public interface IndividualRepository extends JpaRepository<IndividualClient, Long> {
  boolean existsByCpf(String cpf);
}
