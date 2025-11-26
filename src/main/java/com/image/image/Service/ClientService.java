package com.image.image.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.image.image.Dto.StatusDto;
import com.image.image.Model.Accepted;
import com.image.image.Model.Bookings;
import com.image.image.Model.Client;
import com.image.image.Model.Rejected;
import com.image.image.Repo.AcceptedRepo;
import com.image.image.Repo.BookingRepo;
import com.image.image.Repo.ClientRepo;
import com.image.image.Repo.RejectedRepo;

@Service
public class ClientService {

	@Autowired
	ClientRepo clntrepo;
	@Autowired
	BookingRepo bkrepo;
	@Autowired
	AcceptedRepo acptdrepo;
	@Autowired
	RejectedRepo rjctedrepo;
	
	//store Client Details
	public ResponseEntity<?>clientRegister(Client clnt){
		clntrepo.save(clnt);
		return  ResponseEntity.status(200).body("Registed succesFully"+clnt);
	}
	
	//login 
	public ResponseEntity<?>clientLogin(Client clnt){
		Client c=clntrepo.findByCname(clnt.getCname());
		if(c.getCname().equals(clnt.getCname())&&c.getCpass().equals(clnt.getCpass())) {
			return ResponseEntity.status(200).body(c);
		}else {
			return ResponseEntity.status(401).body("Invalid Inputs");
		}
	}
	
	//ListAll accptedOrder
	public ResponseEntity<List<StatusDto>>listAllacptdorder(int cid){

		List<StatusDto> users=bkrepo.acptdorder(cid);
			
//		List<Accepted>acptd=acptdrepo.findByCid(cid);
				
				return ResponseEntity.status(200).body(users);
	}
	//Listall Rejected Order
	public ResponseEntity<List<Rejected>>ListAllrjctedoreder(int cid){
		List<Rejected>rjctd=rjctedrepo.findByCid(cid);
		return ResponseEntity.status(200).body(rjctd);
	}
	
	
	
	
	
	
	}
