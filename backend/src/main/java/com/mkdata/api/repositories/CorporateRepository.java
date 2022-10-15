package com.mkdata.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkdata.api.models.Corporate;

@Repository
public interface CorporateRepository extends JpaRepository<Corporate, Long> {
  boolean existsByCnpj(String cnpj);
}
