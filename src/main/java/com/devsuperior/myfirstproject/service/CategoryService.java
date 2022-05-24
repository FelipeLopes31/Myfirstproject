package com.devsuperior.myfirstproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.devsuperior.myfirstproject.domain.Category;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	
	public Category find(long id) {
		Category obj = repo.find(id);
		
		return obj;
	}
	
	public List<Category> findAll() {
		List<Category> catv = new ArrayList<Category>();
		catv = repo.findAll();
		return catv;
	}
	
	
	public Category insert(Category obj) {
		repo.save(obj);
		return obj;
	}
	
	
	public Category update(Category obj) {
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
