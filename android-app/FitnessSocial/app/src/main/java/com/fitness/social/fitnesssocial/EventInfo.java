package com.fitness.social.fitnesssocial;

import java.util.Calendar;

/**
 * Event Info Block
 */
public class EventInfo {

    // Class Variables
    String eventTitle;
    String eventDescription;
    String eventDate;
    String startTime;
    String location;
    String endTime;
    String creator;
    String [] attendees = new String[]{};
    int lagt;
    int longt;
    boolean active;

    // Constructor
    public EventInfo(){
        Calendar c = Calendar.getInstance();
        int seconds = c.get(Calendar.SECOND);

        eventTitle = "New Event";
        eventDescription = "Description";
        eventDate = "";

        active = false;
    }
}
