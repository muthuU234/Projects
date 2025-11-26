package com.image.image.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.image.image.Model.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{

	public Products findByProdname(String prodname);
}
