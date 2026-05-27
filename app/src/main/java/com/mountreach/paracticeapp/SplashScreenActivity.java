package com.mountreach.paracticeapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreenActivity extends AppCompatActivity {


    LottieAnimationView lottieView;

    String appName = "DocLink";
    int index = 0;
    long dealy = 200;
    TextView tvsplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        lottieView = findViewById(R.id.lottieView);
        lottieView.setAnimation(R.raw.chatting_animation);
        lottieView.playAnimation();

     Handler handler = new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {

               if(index<= appName.length())
               {
                    tvsplash.setText(appName.substring(0,index));
                    index++;
                    handler.postDelayed(this,dealy);
               }
               else
               {
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                           startActivity(intent);
                           finish();
                       }
                   },2000);
               }

           }
       },dealy);


    }
}