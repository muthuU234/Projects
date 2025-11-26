package com.image.image.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.google.common.base.Optional;
import com.image.image.Dto.ProductDto;
import com.image.image.Model.Products;
import com.image.image.Repo.ProductRepo;

@Service
public class ProductService {

	
	@Autowired
	ProductRepo prodrepo;
	
	//change the price of the product
	public ResponseEntity<String>setPice(ProductDto prod){
		Optional<Products> p1=prodrepo.findById(prod.getPid());
//		Products p=prodrepo.findByProdname(prod);
		Products p=p1.get();
		p.setProdprice(prod.getPrice());
		prodrepo.save(p);
		return ResponseEntity.status(200).body("Price Updated Successfully...");
	
	}
	
	// ListOut the Prodcuts
	public ResponseEntity<List<Products>> listAll(){
		List<Products> getall=prodrepo.findAll();
		return ResponseEntity.status(200).body(getall);
	}
	
	//Insert New Product in Table via boot
	public ResponseEntity<String>newProd(Products prod){
		prodrepo.save(prod);
		return ResponseEntity.status(200).body("Products were added successfully..");
		
	}
	
}
