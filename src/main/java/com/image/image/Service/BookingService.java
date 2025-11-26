package com.image.image.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.image.image.Dto.BookingDto;
import com.image.image.Dto.StatusDto;
import com.image.image.Model.Accepted;
import com.image.image.Model.Bookings;
import com.image.image.Model.Client;
import com.image.image.Model.Products;
import com.image.image.Model.Rejected;
import com.image.image.Repo.AcceptedRepo;
import com.image.image.Repo.BookingRepo;
import com.image.image.Repo.ProductRepo;
import com.image.image.Repo.RejectedRepo;

@Service
public class BookingService {
	
	@Autowired
	BookingRepo bkrepo;
	@Autowired
	ProductRepo prepo;
	@Autowired
	RejectedRepo rjrepo;
	@Autowired
	AcceptedRepo acptdrepo;
	
	public ResponseEntity<?>bookCourier(BookingDto bk){
		Bookings b= new Bookings();
		Client c= new Client();
		b.setProdname(bk.getProdname());
		b.setDest(bk.getDest());
		b.setSrc(bk.getSrc());
		b.setWeight(bk.getWeight());
		c.setCid(bk.getCid());
		b.setClient(c);
		Products pricing = prepo.findByProdname(bk.getProdname());
		double price = pricing.getProdprice();
		double wght=bk.getWeight();
		b.setPrice(price*wght);
		b.setStatus("PENDING");
		bkrepo.save(b);
		
		return ResponseEntity.status(200).body(" Wait sometime Your Courier will get confirm soon...\n  Price Of your Courier is     $"+b.getPrice());
		
	}

	public ResponseEntity<?> checkSts(int user_id) {
		List<StatusDto>sts= bkrepo.trackcr(user_id);
		
		
		return ResponseEntity.status(200).body(sts);
//		List<StatusDto> getcr=bkrepo.trackcr(user_id);
//		return ResponseEntity.status(200).body(getcr);
	}
	
	public ResponseEntity<List<Rejected>>rjctd_ords(){
		
		List<Rejected> datas=rjrepo.findAll();
		
			return ResponseEntity.status(200).body(datas);
		
		
	}
	
	public ResponseEntity<List<Accepted>>acptd_ord(){
		List<Accepted>datas=acptdrepo.findAll();
//		return ResponseEntity<List<Accepted>>
		return ResponseEntity.status(200).body(datas);
				 
	}
	
	public ResponseEntity<List<Bookings>>pendingsts(){
		List<Bookings> getAll=bkrepo.findAll();
//		System.err.println("Printing here "+ getAll);
		List<Bookings> response=new ArrayList<Bookings>();
		for(Bookings b:getAll) {
			if(b.getStatus().equals("PENDING")) {
				response.add(b);
			}
		}
		return ResponseEntity.status(200).body(response);
	}

}
