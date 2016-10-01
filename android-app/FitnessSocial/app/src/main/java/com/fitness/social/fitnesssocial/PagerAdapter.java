package com.fitness.social.fitnesssocial;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/*
   PagerAdapter helps populate the tabs on screen
   of Profile, Events, and Map
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

        Context eContext;

        // Constructor
        public PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            eContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frag = null;
            switch (position){
                case 0:
                    frag = new FragmentProfile();
                    break;
                case 1:
                    frag = new FragmentEvent();
                    break;
                case 2:
                    frag = new FragmentMap();
                    break;
            }
            return frag;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = " ";
            switch (position){
                case 0:
                    title = eContext.getString(R.string.tab_000);
                    break;
                case 1:
                    title = eContext.getString(R.string.tab_001);
                    break;
                case 2:
                    title = eContext.getString(R.string.tab_002);
                    break;
            }
            return title;
        }
}
