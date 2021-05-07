package com.saproject.savendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saproject.savendas.dto.SaleDTO;
import com.saproject.savendas.dto.SaleSucessDTO;
import com.saproject.savendas.dto.SaleSumDTO;
import com.saproject.savendas.entities.Sale;
import com.saproject.savendas.repositories.SaleRepository;
import com.saproject.savendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public 	List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	
	@Transactional(readOnly = true)
	public 	List<SaleSucessDTO> sucessGroupedBySeller(){
		return repository.sucessGroupedBySeller();
	}
	
	
	
}
