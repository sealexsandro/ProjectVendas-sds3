package com.saproject.savendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saproject.savendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
