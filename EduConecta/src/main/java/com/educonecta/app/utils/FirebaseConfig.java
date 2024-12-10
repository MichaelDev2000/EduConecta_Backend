package com.educonecta.app.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() throws IOException {
        // Ruta correcta sin comillas extra
        //FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase-service-account.json");

    	ClassLoader classloader = FirebaseConfig.class.getClassLoader();
    	
    	File file = new File(Objects.requireNonNull(classloader.getResource("firebaseserviceaccount.json")).getFile());
    	
    	FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
    	
        FirebaseOptions options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }
}

