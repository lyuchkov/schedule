package ru.lyuchkov.entity;

public class MeetingTime implements Comparable<MeetingTime> {
    private int dayNumber;
    private int timeSlot;

    public int getDayNumber() {
        return dayNumber;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public MeetingTime(int dayNumber, int timeSlot) {
        if(dayNumber>6||dayNumber<1||timeSlot<1||timeSlot>8)
            throw new IllegalArgumentException("The day and slot should be in this segment:\n" +
                    "dayNumber -> [1,6]+\n" +
                    "timeSlot -> [1,8]");
        this.dayNumber = dayNumber;
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        var res = new StringBuilder();
        switch (dayNumber){
            case 1 -> res.append("Пн");
            case 2 -> res.append("Вт");
            case 3 -> res.append("Ср");
            case 4 -> res.append("Чт");
            case 5 -> res.append("Пт");
            case 6 -> res.append("Сб");
        }
        res.append(timeSlot).append("-я пара");
        return res.toString();
    }

    @Override
    public int compareTo(MeetingTime o) {
        if(dayNumber!=o.getDayNumber()){
            return dayNumber-o.getDayNumber();
        }else {
            return timeSlot-o.getTimeSlot();
        }
    }


}
