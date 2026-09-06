package com.image.image.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.image.image.Dto.MessageDTO;
import com.image.image.Dto.NotificationDto;
import com.image.image.Model.Admin;
import com.image.image.Model.Bookings;
import com.image.image.Repo.AdminRepo;
import com.image.image.Repo.BookingRepo;
//import com.image.image.websocket.WebsokcetMethods;

@Service
public class AdminService {

	@Autowired
	AdminRepo admnrepo;
	@Autowired
	BookingRepo bkrepo;

	@Autowired
	SimpMessagingTemplate smptemplate;

//save admin
	public ResponseEntity<?> adminreg(Admin admn) {
		admnrepo.save(admn);
		return ResponseEntity.status(200).body("REGISETRD");
	}

//login admin
	public ResponseEntity<?> admnlog(Admin admn) {
		Admin a = admnrepo.findByAname(admn.getAname());
		if (a.getAname().equals(admn.getAname()) && a.getApass().equals(admn.getApass())) {
			return ResponseEntity.status(200).body("Sucessfully loggedIn");
		} else {
			return ResponseEntity.status(401).body("Invalid Inputs");
		}
	}

//change the status  if the  booking
	public ResponseEntity<?> changestatus(int id, String choice) {
		Optional<Bookings> bk = bkrepo.findById(id);
		Bookings b = bk.get();
		String responseMessage = "";

//		if(bk.isPresent()) {
		System.out.println("ENter a or r");
		if (bk.get().getStatus().equals("PENDING")) {
			if (choice.equals("a")) {
				bk.get().setStatus("ACCEPTED");
				bkrepo.save(b);
				NotificationDto msgnotify = getNotifydetails(id);
				int client_id =msgnotify.getCid();
				responseMessage = "Order Was Accepted..!";
				System.out.println("ClientID => "+client_id);

				smptemplate.convertAndSend("/topic/notify/"+client_id,msgnotify);

			} else if (choice.equals("r")) {
				bk.get().setStatus("REJECTED");
				bkrepo.save(b);
				NotificationDto msgnotify = getNotifydetails(id);
				int client_id =msgnotify.getCid();
				System.out.println("ClientID => "+client_id);
				responseMessage = "Your order Has Been Rejected...";
				smptemplate.convertAndSend("/topic/notify/"+client_id,msgnotify );

			} else {
				return ResponseEntity.status(401).body("PLEASE  ENETR A VALID OPTION ");
			}
		} else {
			return ResponseEntity.status(200).body("Courier was already Booked ...");
		}

		return ResponseEntity.status(200).body(responseMessage);
	}

	
	public  NotificationDto  getNotifydetails(int bid) {
	
		NotificationDto n = admnrepo.msgnotifyValues(bid);
		return n;
		
		
	}
}
