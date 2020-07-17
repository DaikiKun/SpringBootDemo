package com.Firebase.Services;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FBInitiallize {
	
	@PostConstruct
	public void intialize() {
		try {

			FileInputStream serviceAccount =
					new FileInputStream("./servicesAccount.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://fir-db-for-spring-boot-42c61.firebaseio.com")
					.build();

		FirebaseApp.initializeApp(options);

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
