package com.devsuperior.myfirstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.myfirstproject.domain.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query(value= "select * from category where id = ?", nativeQuery = true)
	Category find(Long id);

}