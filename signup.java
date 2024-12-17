package com.example.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    private EditText username, email, password;
    private Button signUpButton,LogInLink;

    // Database helper
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        // Initialize views
        username = findViewById(R.id.usernameInput);
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        signUpButton = findViewById(R.id.signUpButton);


        TextView LogInLink = findViewById(R.id.LogInLink);

        LogInLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
            }
        });

//         Initialize database helper
        dbHelper = new DatabaseHelper(this);

//         Sign up button action
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameText = username.getText().toString().trim();
                String emailText = email.getText().toString().trim();
                String passwordText = password.getText().toString().trim();

                // Basic validation
                if (usernameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(signup.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (dbHelper.checkEmail(emailText)) {
                    Toast.makeText(signup.this, "Email already exists", Toast.LENGTH_SHORT).show();
                } else {
                    boolean insertSuccess = dbHelper.addUser(usernameText, emailText, passwordText);
                    if (insertSuccess) {
                        Toast.makeText(signup.this, "Signed up successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(signup.this, login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(signup.this, "Failed to sign up", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}

