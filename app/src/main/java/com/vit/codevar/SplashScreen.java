package com.vit.codevar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class SplashScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().setStatusBarColor(getApplicationContext().getColor(R.color.background));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        CountDownTimer countDownTimer= new CountDownTimer(2000,1000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
            }
            @Override
            public void onFinish()
            {
                //if ()
                //{
                    //Intent sIntent = new Intent(SplashScreen.this, Login.class);
                    //startActivity(sIntent);
                    //SplashScreen.this.finish();
                //}
                //else
                //{
                    Intent pIntent = new Intent(SplashScreen.this,LoginActivity.class);
                    startActivity(pIntent);
                    SplashScreen.this.finish();
                //}
            }
        };
        countDownTimer.start();
    }
}
