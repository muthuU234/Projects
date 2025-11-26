package com.image.image.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.image.image.Dto.BookingDto;
import com.image.image.Model.Accepted;
import com.image.image.Model.Bookings;
import com.image.image.Model.Rejected;
import com.image.image.Service.BookingService;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

	@Autowired
	BookingService  bkser;
	
	@PostMapping("/book")
	public ResponseEntity<?>bookCourier(@RequestBody BookingDto bk){
		return bkser.bookCourier(bk);
	}
	
	@GetMapping("/status/{id}")
	public ResponseEntity<?>checkStatus(@PathVariable int id){
		return bkser.checkSts(id);
	}
	@GetMapping("/rejected")
	public ResponseEntity<List<Rejected>> rejected_ords(){
		return bkser.rjctd_ords();
	}
	@GetMapping("/accepted")
	public ResponseEntity<List<Accepted>>acptd_ords(){
		return bkser.acptd_ord();
	}
	@GetMapping("/pending")
	public ResponseEntity<List<Bookings>>pendingStatus(){
		return  bkser.pendingsts();
	}
}
