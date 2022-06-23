package com.example.changingballsizepr4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ball;
    private TextView timer;
    private boolean run = true;
    private Integer a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Raj PR4");

        ball = findViewById(R.id.ball);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ball.animate().rotationBy(360).withEndAction(this).setDuration(3000).setInterpolator(new LinearInterpolator()).start();
                ball.setColorFilter(Color.rgb(255,0,0));
//                ball.setScaleX(4);
//                ball.setScaleY(4);
            }
        };


        ball.animate().rotationBy(360).setDuration(60000).setInterpolator(new LinearInterpolator()).start();
        ball.setColorFilter(Color.rgb(255,0,0));
        ball.getLayoutParams().height = 400;
        ball.getLayoutParams().width = 400;

        Start();

//        ball.animate().cancel();


    }

    public void Start() {
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Integer count = a;
                String sec = count.toString();
                timer = findViewById(R.id.textView);
                timer.setText(sec);

                if (run) {
//                    a++;
                    a=a+30;
                }

                if (a == 60){
                    Toast.makeText(MainActivity.this, ""+a, Toast.LENGTH_SHORT).show();
                    ball.animate().rotationBy(360).setDuration(60000).setInterpolator(new LinearInterpolator()).start();
                    ball.setColorFilter(Color.rgb(0,0,255));
                    timer.setBackgroundColor(Color.rgb(100,150,155));
                    ball.getLayoutParams().height = 600;
                    ball.getLayoutParams().width = 600;
                }

                if (a == 120){
                    Toast.makeText(MainActivity.this, ""+a, Toast.LENGTH_SHORT).show();
                    ball.animate().rotationBy(360).setDuration(60000).setInterpolator(new LinearInterpolator()).start();
                    ball.setColorFilter(Color.rgb(0,255,0));
                    timer.setBackgroundColor(Color.rgb(100,200,255));
                    ball.getLayoutParams().height = 800;
                    ball.getLayoutParams().width = 800;

                }

                handler.postDelayed(this, 1000);
            }
        };


        handler.postDelayed(runnable, 1);
        if (a == 180){
//            runnable = null;
            handler.removeCallbacks(runnable);
        }
    }
}