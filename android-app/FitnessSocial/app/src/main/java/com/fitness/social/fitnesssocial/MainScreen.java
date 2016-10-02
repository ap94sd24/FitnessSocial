package com.fitness.social.fitnesssocial;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainScreen extends FragmentActivity {

    // Activity Variables
    ViewPager pager;
    TabLayout tabLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        context = this;
        pager= (ViewPager) findViewById(R.id.view_pager);
        tabLayout= (TabLayout) findViewById(R.id.tab_layout);

        // Fragment manager to add fragment in viewpager we will pass object of Fragment manager to adapter class.
        FragmentManager manager= getSupportFragmentManager();
        PagerAdapter adapter=new PagerAdapter(manager, context);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(adapter);

        // Prompts user for GPS/Location
        LocationManager managerL = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if(!managerL.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //Ask the user to enable GPS
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("GPS Location Manager");
            builder.setMessage("Location is needed for functionality.\nWould you like to enable GPS?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Launch settings, allowing user to make a change
                    Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(i);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //No location service
                    Toast.makeText( getApplicationContext(), "You can turn on Location\nvia Profile tab.", Toast.LENGTH_LONG).show();
                }
            });
            builder.create().show();
        }
    }

    @Override
    public void onBackPressed() {
        // Leaving the App
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Fitness Social");
        builder.setMessage("Do you want to exit the\nFitness Social app?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Exit
                MainScreen.this.finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Don't Exit
            }
        });
        builder.create().show();
    }
}
