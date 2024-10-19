package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
//import com.example.fyp.R;
import androidx.appcompat.app.AppCompatActivity;

public class DropdownActivity extends AppCompatActivity {

    private ImageView imageView2;  // The hamburger menu icon
    private LinearLayout dropdownMenu;  // The dropdown menu container

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown);  // The XML layout file you provided

        // Initialize views
        imageView2 = findViewById(R.id.imageView2);
        dropdownMenu = findViewById(R.id.dropdown_menu);

        // Set the dropdown menu to be hidden initially
        dropdownMenu.setVisibility(View.GONE);

        // Toggle dropdown menu visibility when the menu icon is clicked
        imageView2.setOnClickListener(view -> {
            if (dropdownMenu.getVisibility() == View.GONE) {
                dropdownMenu.setVisibility(View.VISIBLE);  // Show the dropdown menu
            } else {
                dropdownMenu.setVisibility(View.GONE);  // Hide the dropdown menu
            }
        });

        // Handle clicks on each menu item (for demonstration, using Toast messages)
        TextView about = (TextView) findViewById(R.id.dropdown_menu).findViewById(R.id.about);
        about.setOnClickListener(view -> {
            Toast.makeText(DropdownActivity.this, "About clicked", Toast.LENGTH_SHORT).show();
        });

        TextView contact = (TextView) findViewById(R.id.dropdown_menu).findViewById(R.id.contact);
        contact.setOnClickListener(view -> {
            Toast.makeText(DropdownActivity.this, "Contact clicked", Toast.LENGTH_SHORT).show();
        });

//        TextView setting = (TextView) findViewById(R.id.dropdown_menu).findViewById(R.id.setting);
//        setting.setOnClickListener(view -> {
//            Toast.makeText(DropdownActivity.this, "Setting clicked", Toast.LENGTH_SHORT).show();
//        });
    }
}
