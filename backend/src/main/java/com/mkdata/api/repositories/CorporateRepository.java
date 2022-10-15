package com.mkdata.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkdata.api.models.CorporateClient;

@Repository
public interface CorporateRepository extends JpaRepository<CorporateClient, Long> {
  boolean existsByCnpj(String cnpj);
}
