package com.example.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;

public class login extends AppCompatActivity {

    private EditText email, password;
    private LinearLayout dropdownMenu;
    private ImageView imageView2;
    private Button LogInButton;
    private TextView contact, about,SignupLink;

    // Database helper
//    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Initialize database helper
//        dbHelper = new DatabaseHelper(this);


        // Handle sign-up button
        TextView SignupLink = findViewById(R.id.SignupLink);

        SignupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });

        // Handle forgotPassword button
        TextView forgotPassword = findViewById(R.id.ForgotPassword);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, ForgotPassword.class);
                startActivity(intent);
            }
        });

        // Find views by ID
        email = findViewById(R.id.emailInput);
        password = findViewById(R.id.passwordInput);
        imageView2 = findViewById(R.id.imageView2);



        // Handle contact button
        contact = findViewById(R.id.contact);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, contact.class);
                startActivity(intent);
            }
        });

        // Handle about button
        about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, about.class);
                startActivity(intent);
            }
        });



        // Handle login button click
        LogInButton = findViewById(R.id.LogInButton);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString().trim();
                String passwordText = password.getText().toString().trim();

                // Check if any field is empty
                if (emailText.isEmpty()) {
                    Toast.makeText(login.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passwordText.isEmpty()) {
                    Toast.makeText(login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If both fields are filled, proceed to the next activity
                Intent intent = new Intent(login.this, exportFile.class);
                startActivity(intent);
            }
        });


//
//        LogInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String emailText = email.getText().toString().trim();
//                String passwordText = password.getText().toString().trim();
//
//                // Check if any field is empty
//                if (emailText.isEmpty()) {
//                    Toast.makeText(login.this, "Please enter your email", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if (passwordText.isEmpty()) {
//                    Toast.makeText(login.this, "Please enter your password", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                // Check credentials using DatabaseHelper
//                if (dbHelper.checkUser(emailText, passwordText)) {
//                    Intent intent = new Intent(login.this, exportFile.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(login.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


        dropdownMenu = findViewById(R.id.dropdown_menu);
        // Set the dropdown menu to be hidden initially
        dropdownMenu.setVisibility(View.GONE);
        // Handle dropdown menu toggle
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dropdownMenu.getVisibility() == View.GONE) {
                    dropdownMenu.setVisibility(View.VISIBLE);  // Show dropdown
                } else {
                    dropdownMenu.setVisibility(View.GONE);  // Hide dropdown
                }
            }
        });
    }
}
