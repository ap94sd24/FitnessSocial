package com.fitness.social.fitnesssocial;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A fragment class used for Profile/Settings.
 */
public class FragmentProfile extends Fragment implements View.OnClickListener {

    public FragmentProfile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        Button a = (Button) v.findViewById(R.id.privacy_button);
        a.setOnClickListener(this);
        Button b = (Button) v.findViewById(R.id.location_button);
        b.setOnClickListener(this);
        Button c = (Button) v.findViewById(R.id.tos_button);
        c.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // GPS Location Settings
            case R.id.location_button:
                // Prompts user for GPS/Location
                LocationManager managerL = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                if(!managerL.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    //Ask the user to enable GPS
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                            Toast.makeText(getActivity(), "You can turn on Location via Profile.", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.create().show();
                } else {
                    Toast.makeText(getActivity(), "Location is already on.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tos_button:
                Toast.makeText(getActivity(), "Coming soon.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.privacy_button:
                Toast.makeText(getActivity(), "Coming soon.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
