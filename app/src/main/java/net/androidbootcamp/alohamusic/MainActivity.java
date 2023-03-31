package net.androidbootcamp.alohamusic;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    Button btnUkulele;
    Button btnDrums;
    MediaPlayer mpUkulele;
    MediaPlayer mpDrums;
    int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get instance of buttons and set on click listeners
        btnUkulele = findViewById(R.id.btnUkulele);
        btnDrums = findViewById(R.id.btnDrums);
        btnUkulele.setOnClickListener(bUkulele);
        btnDrums.setOnClickListener(bDrums);

        //instances of media players
        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);

        playing = 0;
    }

    Button.OnClickListener bUkulele = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    btnUkulele.setText("Pause Ukulele Song"); //change text when mp3 is playing
                    btnDrums.setVisibility(View.INVISIBLE); //make drums button not visible
                    break;
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    btnUkulele.setText("Play Ukulele Song"); //set text to play song when paused
                    btnDrums.setVisibility(View.VISIBLE); //When paused, drums button is visible
                    break;
            }
        }
    };
    Button.OnClickListener bDrums = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    mpDrums.start();
                    playing = 1;
                    btnDrums.setText("Pause Drums Song"); //change text when mp3 is playing
                    btnUkulele.setVisibility(View.INVISIBLE); //make Ukulele button not visible
                    break;
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    btnDrums.setText("Play Drums Song"); //set text to play song when paused
                    btnUkulele.setVisibility(View.VISIBLE); //When paused, ukulele button is visible
                    break;
            }
        }
    };
}