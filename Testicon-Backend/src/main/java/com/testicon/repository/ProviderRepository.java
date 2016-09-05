package com.testicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testicon.model.Provider;

@Repository("providerRepository")
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
