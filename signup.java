package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup extends AppCompatActivity {

    private EditText username, email, password;
    private Button signUpButton, googleSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        // Initialize views
        username = findViewById(R.id.usernameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        Button signupButton = findViewById(R.id.signUpButton);
        Button googleSignUpButton = findViewById(R.id.googleSignUpButton);

        // Sign up button action
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simple validation (Add more robust validation as needed)
                if (username.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        password.getText().toString().isEmpty()) {
                    Toast.makeText(signup.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    // You can handle sign-up logic here
                    Toast.makeText(signup.this, "Signed up successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Google sign up button action
        googleSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Google sign-up logic here
                Toast.makeText(signup.this, "Sign up with Google", Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}