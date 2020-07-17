package com.Firebase.Services;

import com.Firebase.member.Member;

public interface FirebaseService {
	public String insertMember(Member member)throws Exception;
	
	public Member getMemberDetail(String id) throws Exception;
	
	public String updateMember(Member member)throws Exception;
	
	public String deleteMember(String id)throws Exception;

}
