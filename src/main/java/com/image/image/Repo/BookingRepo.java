package com.image.image.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.image.image.Dto.StatusDto;
import com.image.image.Model.Bookings;
import com.image.image.Model.Client;

@Repository
public interface BookingRepo extends JpaRepository<Bookings, Integer> {

	
	@Query(value="SELECT C.CID ,C.CNAME ,B.STATUS,B.PRODNAME,B.BID ,B.BOOKED_TIME FROM BOOKINGS B JOIN CLIENT C ON B.CID=C.CID WHERE B.CID=:user_id;",nativeQuery=true)
	List<StatusDto>trackcr(@Param("user_id")int u_id);
	
	List<Bookings>findByClient(Client cl);
	List<Bookings> findAllByClient_Cid(int cid);
	
	@Query(value="SELECT C.CID ,C.CNAME ,B.STATUS,B.PRODNAME,B.BID ,B.BOOKED_TIME FROM BOOKINGS B JOIN CLIENT C ON B.CID=C.CID WHERE B.CID=:user_id AND B.STATUS='ACCEPTED';",nativeQuery=true)
	List<StatusDto>acptdorder(@Param("user_id")int u_id);
	
	
	

	
	
}
