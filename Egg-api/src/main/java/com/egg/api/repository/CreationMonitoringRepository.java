package com.egg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egg.api.model.CreationMonitoring;
import com.egg.api.repository.query.CreationMonitoringRepositoryQuery;


public interface CreationMonitoringRepository extends JpaRepository<CreationMonitoring, Long>, CreationMonitoringRepositoryQuery {

}
