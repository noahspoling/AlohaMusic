package net.androidbootcamp.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                //Display Main activity after splash screen
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        };
        //creates TimerTask object that displays main activity after 5000ms
        Timer opening = new Timer();
        opening.schedule(task, 5000);
    }
}