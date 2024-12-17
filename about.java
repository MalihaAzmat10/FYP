package com.example.fyp;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.text.Html;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);


        // Find the TextView by its ID
        TextView textView = findViewById(R.id.bullet);

        // Bullet points content using HTML formatting
        String bulletPoints = "<ul>" +
                "<li> Customer Segmentation. </li>" +
                "<li> RFM Analysis.</li>" +
                "<li> RFM Analysis.</li>" +
                "<li> Feedback Analysis.</li>" +
                "</ul>";

        // Set the formatted text to the TextView
        textView.setText(Html.fromHtml(bulletPoints));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
