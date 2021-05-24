package com.prana.financial.repository;

import com.prana.financial.domain.TaxConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaxConfigRepository extends JpaRepository<TaxConfig, Long>, JpaSpecificationExecutor<TaxConfig> {
}
