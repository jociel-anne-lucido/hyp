package com.example.sleepgraphyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock extends AppCompatActivity {
    TextView textView;

    private ImageView button_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        textView=findViewById(R.id.greetings);
        button_profile = findViewById(R.id.profile);

        button_profile.setOnClickListener(v -> startActivity(new Intent(Clock.this, UserSettings.class)));

        ShowDate();
        ShowGreetings();

        BottomNavigationView bottomNavigationView= (BottomNavigationView)findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.home:
                    break;
                case R.id.tracker:
                    Intent intent2= new Intent(Clock.this,Tracker.class);
                    startActivity(intent2);
                    break;
                case R.id.analysis:
                    Intent intent3= new Intent(Clock.this,Analysis.class);
                    startActivity(intent3);
                    break;
            }
            return false;
        });
    }

    private void ShowDate() {
        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");

        String day = dayFormat.format(today);
        String date = dateFormat.format(today);

        TextView textViewDay = findViewById(R.id.day);
        TextView textViewDate = findViewById(R.id.date);

        textViewDay.setText("Today, "+day);
        textViewDate.setText(date);
    }

    private void ShowGreetings() {
        Calendar calendar = Calendar.getInstance();
        int Hours=calendar.get(Calendar.HOUR_OF_DAY);

        if (Hours > 0 && Hours < 12) {
            textView.setText("Good" + System.lineSeparator() + "Morning!");
        } else if(Hours>=12 && Hours<17) {
            textView.setText("Good" + System.lineSeparator() + "Afternoon!");
        } else {
            textView.setText("Good Night!");
        }
    }
}