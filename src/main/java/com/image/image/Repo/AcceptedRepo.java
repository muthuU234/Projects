package com.image.image.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.image.image.Dto.StatusDto;
import com.image.image.Model.Accepted;

@Repository
public interface AcceptedRepo extends JpaRepository<Accepted, Integer> {
	
//	@Query(value="SELECT A.BID, B.PRODNAME, A.CID, C.CNAME FROM ACCEPTED A LEFT JOIN BOOKINGS B ON A.BID = :bid LEFT JOIN CLIENT C ON A.CID = :cid;",nativeQuery=true)
//	List<OrderDto>findBycid(@Param("cid")int cid,@Param("bid")int bid);

List<Accepted>findByCid(int cid);
}
