package com.osk.SpringTest;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserControl {
	@Autowired
	private UserService uservice;
	
	@GetMapping("/userinfo")
	public List<User> list(){
		return uservice.listAll();
		
	}
	
	@GetMapping("/userinfo/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id) {
		try {
		User user=uservice.get(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/userinfo")
	public void add(@RequestBody User user) {
		uservice.save(user);
		
	}
	@PutMapping("/userinfo/{id}")
	public ResponseEntity<?> update(@RequestBody User user,@PathVariable Integer id) {
		try {
		User existuser=uservice.get(id);
		uservice.save(user);
		return new ResponseEntity<>(user,HttpStatus.OK);
		}catch(NoSuchElementException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	@DeleteMapping("/userinfo/{id}")
	public void delete(@PathVariable Integer id) {
		uservice.delete(id);
	}
		
	
}