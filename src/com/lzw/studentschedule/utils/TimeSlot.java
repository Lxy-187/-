package com.lzw.studentschedule.utils;

import java.util.ArrayList;

public enum TimeSlot {
    SLOT_1(1, "08:00-08:45"),
    SLOT_2(2, "08:50-09:35"),
    SLOT_3(3, "09:50-10:35"),
    SLOT_4(4, "10:40-11:25"),
    SLOT_5(5, "11:30-12:15"),
    SLOT_6(6, "13:00-13:45"),
    SLOT_7(7, "13:50-14:35"),
    SLOT_8(8, "14:45-15:30"),
    SLOT_9(9, "15:40-16:25"),
    SLOT_10(10, "16:35-17:20"),
    SLOT_11(11, "17:25-18:10"),
    SLOT_12(12, "18:30-19:15"),
    SLOT_13(13, "19:20-20:05"),
    SLOT_14(14, "20:10-20:55");

    private final int slotNum;
    private final String timeRange;

    TimeSlot(int slotNum, String timeRange) {
        this.slotNum = slotNum;
        this.timeRange = timeRange;
    }
    public static TimeSlot of(int slotNum){
        for (TimeSlot timeSlot : TimeSlot.values()) {
            if (timeSlot.slotNum == slotNum) {
                return timeSlot;
            }
        }
        return null;
    }
    public static ArrayList<TimeSlot> of(ArrayList<Integer> slotNums){
        ArrayList<TimeSlot> timeSlots = new ArrayList<>();
        for (Integer slotNum : slotNums) {
            timeSlots.add(of(slotNum));
        }
        return timeSlots;
    }

    public int getSlotNum() {
        return slotNum;
    }

    public String getTimeRange() {
        return timeRange;
    }
}
