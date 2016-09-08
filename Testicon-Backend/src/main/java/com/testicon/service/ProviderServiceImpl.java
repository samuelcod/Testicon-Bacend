package com.testicon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testicon.model.Provider;
import com.testicon.repository.ProviderRepository;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	ProviderRepository providerRepository;
	
	@Override
	public List<Provider> findAll() {
		// TODO Auto-generated method stub
		return providerRepository.findAll();
	}
}
