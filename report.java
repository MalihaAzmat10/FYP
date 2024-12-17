package com.example.fyp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class report extends AppCompatActivity {
    private ScrollView scrollView;
    private LinearLayout dropdownMenu;
    private ImageView imageView2;
    private TextView setting;
    private TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_report);

//        about = findViewById(R.id.about);

        // Initialize ScrollView and ImageView objects
        scrollView = findViewById(R.id.scrollView);
        imageView2 = findViewById(R.id.imageView2);
        dropdownMenu = findViewById(R.id.dropdown_menu);
        setting = findViewById(R.id.setting);
        logout = findViewById(R.id.logout);

        // Set the dropdown menu to be hidden initially
        dropdownMenu.setVisibility(View.GONE);


        setting.setOnClickListener(view -> {
            Intent intent = new Intent(report.this, userSetting.class);
            startActivity(intent);
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(report.this, login.class);
                startActivity(intent);
            }
        });


        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, 100);  // Scroll down 100 pixels from the top
            }
        });


        imageView2.setOnClickListener(view -> {
            if (dropdownMenu.getVisibility() == View.GONE) {
                dropdownMenu.setVisibility(View.VISIBLE);  // Show dropdown
                Log.d("Dropdown", "Dropdown is now visible");
            } else {
                dropdownMenu.setVisibility(View.GONE);  // Hide dropdown
                Log.d("Dropdown", "Dropdown is now hidden");
            }
        });


    }
}


