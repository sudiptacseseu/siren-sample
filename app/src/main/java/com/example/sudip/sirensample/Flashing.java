package com.example.sudip.sirensample;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class Flashing extends AppCompatActivity {

    private ImageView imageViewFlashing;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashing);

        getSupportActionBar().hide();

        imageViewFlashing = findViewById(R.id.imageView_Id);

        startSiren();
        startLights();
    }

    public void startSiren(){

        mediaPlayer = MediaPlayer.create(this,R.raw.police_siren);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    @SuppressLint("WrongConstant")
    public void startLights(){

        ObjectAnimator animator = ObjectAnimator.ofInt(imageViewFlashing,"BackgroundColor", Color.RED,Color.BLUE);

        animator.setDuration(120);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setRepeatMode(Animation.REVERSE);
        animator.setRepeatCount(Animation.INFINITE);
        animator.start();
    }

    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }
}
