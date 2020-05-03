package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.ProductionMonitoring;
import com.egg.api.repository.query.ProductionMonitoringRepositoryQuery;


public interface ProductionMonitoringRepository extends JpaRepository<ProductionMonitoring, Long>, ProductionMonitoringRepositoryQuery {

}
