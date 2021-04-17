package com.jobs.portal.jobsportal.repository;


import com.jobs.portal.jobsportal.entity.TransactionLoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLoggerRepository extends JpaRepository<TransactionLoggerEntity, Integer> {

        }