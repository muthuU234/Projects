package com.image.image.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.image.image.Model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer>{
		public Client findByCname(String name);
}
