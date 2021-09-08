package com.egg.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.domain.model.CreationMonitoring;
import com.egg.domain.repository.query.CreationMonitoringRepositoryQuery;


public interface CreationMonitoringRepository extends JpaRepository<CreationMonitoring, Long>, CreationMonitoringRepositoryQuery {

}
