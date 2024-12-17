package com.example.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_SCREEN_TIMEOUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

        // Make API Call
        Call<List<User>> call = apiService.getUsers();  // Correct method name
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    List<User> users = response.body();
                    for (User user : users) {
                        Log.d("User", "ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
                    }
                } else {
                    Log.e("Error", "Response not successful: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });

        // Delay for 5 seconds, then navigate to the next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, login.class); // Target activity
                startActivity(intent);
                finish(); // Close the SplashScreenActivity
            }
        }, SPLASH_SCREEN_TIMEOUT);
    }
}
