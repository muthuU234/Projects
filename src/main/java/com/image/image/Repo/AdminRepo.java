package com.image.image.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.image.image.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByAname(String name);
}
