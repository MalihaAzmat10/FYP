package com.example.project;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class login extends AppCompatActivity {
    private EditText email, password;
    private LinearLayout dropdownMenu;
    private ImageView imageView2;
    private Button LogInButton;
    private TextView  contact, about;
    private TextView SignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Find the SignUpButton TextView by its ID
        SignUpButton = findViewById(R.id.SignUpButton);

        // Set an OnClickListener to make it clickable
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When clicked, navigate to the signup activity
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });

        TextView forgotPassword = findViewById(R.id.ForgotPassword);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, ForgotPassword.class);
                startActivity(intent);
            }
        });


//         Find views by ID
        email = findViewById(R.id.emailInput);  // Assuming you have an EditText with ID 'email'
        password = findViewById(R.id.passwordInput);
        imageView2 = findViewById(R.id.imageView2);
        dropdownMenu = findViewById(R.id.dropdown_menu);
//          setting = findViewById(R.id.setting);
        contact = findViewById(R.id.contact);
        about = findViewById(R.id.about);
        LogInButton = findViewById(R.id.LogInButton);


        // Set the dropdown menu to be hidden initially
        dropdownMenu.setVisibility(View.GONE);

        // Set up the login button click listener
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For now, just open the report activity
//                Intent intent = new Intent(login.this, report.class);
//                startActivity(intent);
//                finish();  // Optional: Close this activity so the user can't go back
            }
        });

//        TextView contact = findViewById(R.id.contact);
        contact.setOnClickListener(view -> {
            Intent intent = new Intent(login.this, contact.class);
            startActivity(intent);
        });
        // Handle clicks on each menu item (About)
//        TextView about = findViewById(R.id.about);
        about.setOnClickListener(view -> {
            Intent intent = new Intent(login.this, about.class);
            startActivity(intent);
        });
//        report.setOnClickListener(view -> {
//        Intent intent = new Intent(login.this, report.class); // Target activity
//        startActivity(intent);
//        });


        //    Method to toggle the dropdown menu visibility
        imageView2.setOnClickListener(view -> {
            if (dropdownMenu.getVisibility() == View.GONE) {
                dropdownMenu.setVisibility(View.VISIBLE);  // Show dropdown
            } else {
                dropdownMenu.setVisibility(View.GONE);  // Hide dropdown
            }
        });
    }
    }
//    // Handle SignUp button click
//        signUpButton.setOnClickListener(view -> {
//        // For example, open a signup activity
//        // startActivity(new Intent(login.this, SignupActivity.class));
//        Toast.makeText(login.this, "Sign Up clicked", Toast.LENGTH_SHORT).show();
//    });
//
//    // Handle Forgot Password button click
//        forgotPassword.setOnClickListener(view -> {
//        Toast.makeText(login.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
//    });

