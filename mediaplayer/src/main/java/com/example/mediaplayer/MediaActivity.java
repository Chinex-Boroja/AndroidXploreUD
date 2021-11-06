package com.example.mediaplayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
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

    // Audio manager instance to manage or
    // handle the audio interruptions
    AudioManager audioManager;

    // Audio attributes instance to set the playback
    // attributes for the media player instance
    // these attributes specify what type of media is
    // to be played and used to callback the audioFocusChangeListener
    AudioAttributes playbackAttributes;

    // media player is handled according to the
    // change in the focus which Android system grants for
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                mediaPlayer.release();
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        // get the audio system service for
        // the audioManger instance
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // initiate the audio playback attributes
        playbackAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        // set the playback attributes for the focus requester
        AudioFocusRequest focusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN).
                setAudioAttributes(playbackAttributes)
                .setAcceptsDelayedFocusGain(true)
                .setOnAudioFocusChangeListener(audioFocusChangeListener)
                .build();

        // request the audio focus and
        // store it in the int variable
        final int audioFocusRequest = audioManager.requestAudioFocus(focusRequest);

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

            // request the audio focus by the Android system
            // if the system grants the permission
            // then start playing the audio file
            if (audioFocusRequest == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MediaActivity.this, "Done playing", Toast.LENGTH_SHORT).show();
                    }
                });
            }
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