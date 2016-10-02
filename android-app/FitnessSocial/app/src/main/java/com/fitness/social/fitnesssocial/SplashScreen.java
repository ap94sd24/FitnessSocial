package com.fitness.social.fitnesssocial;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class SplashScreen extends Activity {

    // Activity Variables
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_splash_screen);

        loginButton = (LoginButton)findViewById(R.id.fb_login_button);

        // Facebook Initializer
        callbackManager = CallbackManager.Factory.create();
        AppEventsLogger.activateApp(this);

        // Facebook Login Button Results
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "Login successfully.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MainScreen.class);
                //intent.putExtra("EXTRA_SESSION_ID", sessionId);
                startActivity(intent);
            }
            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Login cancelled.", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(), "Unable to login.", Toast.LENGTH_SHORT).show();

            }
        });
    }

    // TEST: Proceeds onto Main Screen
    public void onProceed(View view) {
        Intent intent = new Intent(getBaseContext(), MainScreen.class);
        //intent.putExtra("EXTRA_SESSION_ID", sessionId);
        startActivity(intent);
    }

}
