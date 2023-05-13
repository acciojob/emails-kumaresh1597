package com.driver;

import java.time.LocalTime;
import java.util.Comparator;

public class Meeting {
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public static Comparator<Meeting> startTimeCompare = new Comparator<Meeting>() {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            int i = o1.startTime.compareTo(o2.startTime);
            return i;
        }
    };
}
