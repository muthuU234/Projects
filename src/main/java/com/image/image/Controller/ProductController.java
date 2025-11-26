package com.image.image.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.image.image.Dto.ProductDto;
import com.image.image.Model.Products;
import com.image.image.Service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	ProductService prodser;
	@PutMapping("/changeprice")
	public ResponseEntity<String> updatePrice( @RequestBody ProductDto prod){
		return prodser.setPice(prod);
	}
	@GetMapping("/getproducts")
	public ResponseEntity<List<Products>>getProducts(){
		return prodser.listAll();
	}
	@PostMapping("/newprod")
	public ResponseEntity<String>saveProd(@RequestBody Products prod){
		return prodser.newProd(prod);
	}
}
