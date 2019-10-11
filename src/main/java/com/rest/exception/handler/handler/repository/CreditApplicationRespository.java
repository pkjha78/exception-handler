package com.rest.exception.handler.handler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.exception.handler.handler.entity.CreditApplication;

@Repository
public interface CreditApplicationRespository extends JpaRepository<CreditApplication, Long> {
}