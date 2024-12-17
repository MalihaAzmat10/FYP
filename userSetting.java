package com.example.fyp;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class userSetting extends AppCompatActivity {
    private EditText nameEditText, emailEditText, passwordEditText;
    private Button deleteAccountButton, backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_setting);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        deleteAccountButton = findViewById(R.id.deleteAccountButton);
        backButton = findViewById(R.id.backButton);

        // Delete Account button action
        deleteAccountButton.setOnClickListener(v -> {
            // Handle account deletion logic
            Toast.makeText(userSetting.this, "Account deleted!", Toast.LENGTH_SHORT).show();
            // Redirect to some other activity after deletion
        });

        // Back button action
        backButton.setOnClickListener(v -> {
            // Go back to the previous activity
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
