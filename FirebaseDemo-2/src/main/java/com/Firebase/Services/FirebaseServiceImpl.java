package com.Firebase.Services;

import org.springframework.stereotype.Service;

import com.Firebase.member.Member;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseServiceImpl implements FirebaseService{
	
	public static final String Col_name="member";
	
	@Override
	public String insertMember(Member member) throws Exception {
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> apiFuture = firestore.collection(Col_name).document(member.getId()).set(member);
		return apiFuture.get().getUpdateTime().toString();

	}

	@Override
	public Member getMemberDetail(String id) throws Exception {
		Firestore firestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = firestore.collection(Col_name).document(id);
		ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
		DocumentSnapshot documentSnapshot = apiFuture.get();
		Member member = null;
		if(documentSnapshot.exists()) {
			member = documentSnapshot.toObject(Member.class);
			return member;
		}else {
			return null;
		}
	}

	@Override
	public String updateMember(Member member) throws Exception {
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> apiFuture = firestore.collection(Col_name).document(member.getId()).set(member);
		return apiFuture.get().getUpdateTime().toString();
	}

	@Override
	public String deleteMember(String id) throws Exception {
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> apiFuture = firestore.collection(Col_name).document(id).delete();
		return "Document id : " + id + " delete";
	}

}