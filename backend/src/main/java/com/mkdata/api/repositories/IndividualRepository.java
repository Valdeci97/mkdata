package com.mkdata.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkdata.api.models.Individual;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long> {
  boolean cpfExists(String cpf);
}
