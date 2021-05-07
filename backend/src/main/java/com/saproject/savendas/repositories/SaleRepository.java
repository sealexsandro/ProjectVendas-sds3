package com.saproject.savendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.saproject.savendas.dto.SaleSucessDTO;
import com.saproject.savendas.dto.SaleSumDTO;
import com.saproject.savendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.saproject.savendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new com.saproject.savendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals) )"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> sucessGroupedBySeller();


}
