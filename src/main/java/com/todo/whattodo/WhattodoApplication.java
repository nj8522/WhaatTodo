package com.todo.whattodo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

@SpringBootApplication
public class WhattodoApplication {

	public static void main(String[] args) {
		try {
			InputStream serviceAccount = WhattodoApplication.class.getResourceAsStream("/serviceAccount.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();
			FirebaseApp.initializeApp(options);
            System.out.println("Firebase Init Completed : "+ FirebaseApp.getInstance().getName());
		} catch (Exception e) {
			System.out.println("Firebase init : "+e.getMessage());
		}

		SpringApplication.run(WhattodoApplication.class, args);
	}

}
