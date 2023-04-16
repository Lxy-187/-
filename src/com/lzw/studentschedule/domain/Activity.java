package com.lzw.studentschedule.domain;

import java.sql.Time;

public interface Activity {
    public void printActivity();
    public String getActivityType();
    public Activity getActivity();
    public Time[] getTimeRange();
}
