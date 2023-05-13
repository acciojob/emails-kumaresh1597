package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        calendar = new ArrayList<>();
        // The inboxCapacity is equal to the maximum value an integer can store.
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
      calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        ArrayList<Pair<LocalTime,Integer>> end = new ArrayList<>();
        for (int i = 0; i < calendar.size(); i++) {
            end.add(Pair.of(calendar.get(i).getEndTime(),i));
        }
        Collections.sort(end);
        LocalTime t = end.get(0).getLeft();
        int count = 0;
        if(!(end.isEmpty())) {
            count = 1;
            for (int i = 1; i < end.size(); i++) {
                if (calendar.get(end.get(i).getRight()).getStartTime().compareTo(t) > 0) {
                    count++;
                    t = end.get(i).getLeft();
                }
            }
        }
        return count;
    }
}
