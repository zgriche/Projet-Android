package com.example.odooandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Authentification extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            authenticateUser(email, password);
        });
    }

    private void authenticateUser(String email, String password) {
        // Pseudo-code pour illustrer l'authentification
        boolean isAuthenticated = checkCredentials(email, password);
        if (isAuthenticated) {
            Toast.makeText(this, "Authentication successful!", Toast.LENGTH_SHORT).show();
            // Lancer une nouvelle activité ou mettre à jour l'UI ici
        } else {
            Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show();
        }
    }

    // Cette méthode doit interagir avec votre backend pour vérifier les identifiants
    private boolean checkCredentials(String email, String password) {
        // Implémentez la logique de vérification ici, appel à une API par exemple
        return true; // Retourne true si les identifiants sont corrects
    }
}