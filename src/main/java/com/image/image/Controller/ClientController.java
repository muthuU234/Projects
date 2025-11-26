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

import com.image.image.Dto.StatusDto;
import com.image.image.Model.Accepted;
import com.image.image.Model.Bookings;
import com.image.image.Model.Client;
import com.image.image.Model.Rejected;
import com.image.image.Service.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")

public class ClientController {

	@Autowired
	ClientService clntser;
	
	@PostMapping("/clientregister")
	public ResponseEntity<?>clientReg(@RequestBody Client clnt){
		return clntser.clientRegister(clnt);
	}
	@PostMapping("/clnt_login")
	public ResponseEntity<?>clientLog(@RequestBody Client clnt){
		return clntser.clientLogin(clnt);
		
	}
	@GetMapping("/accepted_order/{id}")
	public ResponseEntity<List<StatusDto>>acptdOrder(@PathVariable int id){
		return clntser.listAllacptdorder(id);
	}
	@GetMapping("/rejected_order/{id}")
	public ResponseEntity<List<Rejected>>rjctdOrder(@PathVariable int  id){
		return clntser.ListAllrjctedoreder(id);
	}
}
