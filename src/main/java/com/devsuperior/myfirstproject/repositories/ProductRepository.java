package com.devsuperior.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.myfirstproject.domain.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query(value= "select * from product where id = ?", nativeQuery = true)
	Product find(Long id);


}