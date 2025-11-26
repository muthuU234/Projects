package com.image.image.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.image.image.Model.Admin;
import com.image.image.Service.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")

public class AdminController {
	
	@Autowired
	AdminService admnser;
	
	@PostMapping("/register")
	public ResponseEntity<?>adminreg(@RequestBody Admin admn){
		return admnser.adminreg(admn);
	}
	
	@PutMapping("/setstatus/{cid}/{choice}")
	public ResponseEntity<?>changeStatus(@PathVariable int cid,@PathVariable String choice){
		return admnser.changestatus(cid,choice);
	}
	@PostMapping("/admnlogin")
	public ResponseEntity<?>admnLogin(@RequestBody Admin admn){
		return admnser.admnlog(admn);
	}
}
