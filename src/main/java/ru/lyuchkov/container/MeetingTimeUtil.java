package ru.lyuchkov.container;

import ru.lyuchkov.entity.MeetingTime;

import java.util.ArrayList;
import java.util.List;


public class MeetingTimeUtil {
      public static List<MeetingTime> getMeetingTime() {
        List<MeetingTime> res = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 9; j++) {
                res.add(new MeetingTime(i,j));
            }
        }
        return res;
    }

}
