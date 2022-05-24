package com.devsuperior.myfirstproject.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.myfirstproject.domain.Product;
import com.devsuperior.myfirstproject.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Product obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Product> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Product> insert(@RequestBody Product obj) {
		Product objNovo = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(objNovo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(objNovo);
	}

	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Product obj, @PathVariable Long id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
			service.delete(id);
			return ResponseEntity.noContent().build();
	}
}