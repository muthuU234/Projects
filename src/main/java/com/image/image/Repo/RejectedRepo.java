package com.image.image.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.image.image.Model.Rejected;

@Repository
public interface RejectedRepo extends JpaRepository<Rejected, Integer> {
		
	List<Rejected>findByCid(int cid);
}
