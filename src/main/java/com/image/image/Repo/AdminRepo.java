package com.image.image.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.image.image.Dto.NotificationDto;
import com.image.image.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	public Admin findByAname(String name);
	
	@Query(value ="select c.bid,c.prodname,c.weight,c.booked_time,cd.cname,c.status,cd.cid \r\n"
			+ " from bookings c join client cd on cd.CID = c.CID where c.bid=:bid;",nativeQuery = true)
	
	public NotificationDto msgnotifyValues(@Param("bid") int bid );
}
