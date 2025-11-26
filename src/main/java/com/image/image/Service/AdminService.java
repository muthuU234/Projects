package com.image.image.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.image.image.Model.Admin;
import com.image.image.Model.Bookings;
import com.image.image.Repo.AdminRepo;
import com.image.image.Repo.BookingRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo admnrepo;
	@Autowired 
	BookingRepo bkrepo;
//save admin
	public ResponseEntity<?> adminreg(Admin admn){
		 admnrepo.save(admn);
		 return ResponseEntity.status(200).body("REGISETRD");
	}

//login admin
	public ResponseEntity<?>admnlog(Admin admn){
		Admin a=admnrepo.findByAname(admn.getAname());
		if(a.getAname().equals(admn.getAname())&&a.getApass().equals(admn.getApass())) {
			return ResponseEntity.status(200).body("Sucessfully loggedIn");
		}else {
			return ResponseEntity.status(401).body("Invalid Inputs");
		}
	}
//change the status  if the  booking
	public ResponseEntity<?> changestatus(int id,String choice){
		Optional<Bookings> bk= bkrepo.findById(id);
		Bookings b= bk.get();
		
//		if(bk.isPresent()) {
			System.out.println("ENter a or r");
					if(bk.get().getStatus().equals("PENDING")) {
							if(choice.equals("a")) {
						bk.get().setStatus("ACCEPTED");
						bkrepo.save(b);
						return ResponseEntity.status(200).body("Order Was Accepted..!");

							}else if(choice.equals("r")) {
								bk.get().setStatus("REJECTED");
								bkrepo.save(b);
								return ResponseEntity.status(200).body("Order Was REJECTED..!");

							}else {
								return ResponseEntity.status(401).body("PLEASE  ENETR A VALID OPTION ");
							}
					}else {
						return ResponseEntity.status(200).body("Courier was already Booked ...");
					}
			}
		}
		
	
	

