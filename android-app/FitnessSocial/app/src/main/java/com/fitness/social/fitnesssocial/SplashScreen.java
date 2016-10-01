package com.fitness.social.fitnesssocial;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    // TEST: Proceeds onto Main Screen
    public void onProceed(View view) {
        Intent intent = new Intent(getBaseContext(), MainScreen.class);
        //intent.putExtra("EXTRA_SESSION_ID", sessionId);
        startActivity(intent);
    }

}
