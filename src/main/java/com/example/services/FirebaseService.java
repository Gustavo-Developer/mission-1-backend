package com.example.services;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.auth.oauth2.GoogleCredentials;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.io.FileInputStream;
import java.io.IOException;

@ApplicationScoped
public class FirebaseService {

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/google-services.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao inicializar o Firebase: " + e.getMessage(), e);
        }
    }

    public FirebaseToken verifyToken(String idToken) {
        if (idToken != null && idToken.startsWith("Bearer ")) {
            idToken = idToken.substring(7);  // Remover o prefixo "Bearer "
        }

        try {
            return FirebaseAuth.getInstance().verifyIdToken(idToken);
        } catch (Exception e) {
            throw new RuntimeException("Token inválido: " + e.getMessage(), e);
        }
    }

    public Response validateUser(String idToken) {
        try {
            FirebaseToken decodedToken = verifyToken(idToken);
            return Response.ok(decodedToken.getUid()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Token inválido").build();
        }
    }
}
