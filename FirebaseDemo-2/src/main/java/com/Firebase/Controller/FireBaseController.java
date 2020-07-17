package com.Firebase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Firebase.Services.FirebaseServiceImpl;
import com.Firebase.member.Member;

@RestController
public class FireBaseController {
	@Autowired
	FirebaseServiceImpl firebaseService;
	
	@PostMapping("/insertMember")
	public String insertMember(@RequestParam Member member) throws Exception {
		return firebaseService.insertMember(member);
	}
	
	@GetMapping("/getMemberDetail")
	public Member getMemberDetail(@RequestParam String id) throws Exception {
		return firebaseService.getMemberDetail(id);
	}
	
	@PutMapping("/updateMember")
	public String updateMember(@RequestParam Member member) throws Exception {
		return firebaseService.updateMember(member);
	}
	
	@DeleteMapping("/deleteMember")
	public String deleteMember(@RequestParam String id) throws Exception {
		return firebaseService.deleteMember(id);
	}
}