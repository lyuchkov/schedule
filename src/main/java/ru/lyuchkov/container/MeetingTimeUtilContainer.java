package ru.lyuchkov.container;

import ru.lyuchkov.entity.MeetingTime;

import java.util.ArrayList;
import java.util.List;

public class MeetingTimeUtilContainer {
    private static List<MeetingTime> times;

    public MeetingTimeUtilContainer() {
        times = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 9; j++) {
                times.add(new MeetingTime(i,j));
            }
        }
    }

}
