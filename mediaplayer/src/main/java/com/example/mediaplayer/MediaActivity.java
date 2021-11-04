package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MediaActivity extends AppCompatActivity {
    public static int oneTime = 0;

    Button play, pause, seekLeft, seekRight;
    private MediaPlayer mediaPlayer;

    private double startTime = 0;
    private double endTime = 0;

    private final Handler myHandler = new Handler();
    private final int forwardTime = 5000;
    private final int backwardTime = 5000;
    private SeekBar seekbar;
    TextView tx1,tx2,tx3;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        mediaPlayer = MediaPlayer.create(this, R.raw.work);

        play = findViewById(R.id.button3);
        pause = findViewById(R.id.button2);
        seekLeft = findViewById(R.id.button);
        seekRight = findViewById(R.id.button4);

        tx1 = findViewById(R.id.textView2);
        tx2 = findViewById(R.id.textView3);

        seekbar = findViewById(R.id.seekBar);
        seekbar.setClickable(false);
        pause.setEnabled(false);

        play.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),
                    "Playing",Toast.LENGTH_SHORT).show();
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Toast.makeText(MediaActivity.this, "Done playing", Toast.LENGTH_SHORT).show();
                }
            });
            endTime = mediaPlayer.getDuration();
            startTime = mediaPlayer.getCurrentPosition();

            if (oneTime == 0) {
                seekbar.setMax((int) endTime);
                oneTime = 1;
            }
            tx2.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) endTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) endTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    endTime)))
            );

            tx1.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    startTime)))
            );

            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(UpdateSongTime,100);
            pause.setEnabled(true);
            play.setEnabled(false);
        });

        pause.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),
                    "Pausing sound",Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
            pause.setEnabled(false);
            play.setEnabled(true);
        });

        seekRight.setOnClickListener(v -> {
            int temp = (int)startTime;

            if((temp+forwardTime)<=endTime){
                startTime = startTime + forwardTime;
                mediaPlayer.seekTo((int) startTime);
                Toast.makeText(getApplicationContext(),
                        "You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),
                        "Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
            }
        });

        seekLeft.setOnClickListener(v -> {
            int temp = (int)startTime;

            if((temp-backwardTime)>0){
                startTime = startTime - backwardTime;
                mediaPlayer.seekTo((int) startTime);
                Toast.makeText(getApplicationContext(),
                        "You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),
                        "Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private final Runnable UpdateSongTime = new Runnable() {
        @SuppressLint("DefaultLocale")
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tx1.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}