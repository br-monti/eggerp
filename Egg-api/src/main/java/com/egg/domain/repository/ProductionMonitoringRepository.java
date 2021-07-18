package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.ProductionMonitoring;
import com.egg.domain.repository.query.ProductionMonitoringRepositoryQuery;


public interface ProductionMonitoringRepository extends JpaRepository<ProductionMonitoring, Long>, ProductionMonitoringRepositoryQuery {

}
