package com.devsuperior.myfirstproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.devsuperior.myfirstproject.domain.Product;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	
	public Product find(long id) {
		Product obj = repo.find(id);
		
		return obj;
	}
	
	public List<Product> findAll() {
		List<Product> catv = new ArrayList<Product>();
		catv = repo.findAll();
		return catv;
	}
	
	
	public Product insert(Product obj) {
		repo.save(obj);
		return obj;
	}
	
	
	public Product update(Product obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		find(id);

		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("");
		}
	}
	
}



