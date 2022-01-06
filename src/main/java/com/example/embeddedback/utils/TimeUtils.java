package com.example.embeddedback.utils;

import com.example.embeddedback.pojo.TimeRange;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TimeUtils {
//    public static void main(String[] args) {
//        List<TimeRange> cur = new ArrayList<>();
//        cur.add(new TimeRange("10:20:13", "12:30:21"));
//        cur.add(new TimeRange("09:30:21", "10:30:12"));
//        cur.add(new TimeRange("14:20:12", "16:10:21"));
//        cur.add(new TimeRange("15:21:21", "17:45:40"));
//        cur.add(new TimeRange("21:00:00", "23:00:00"));
//
//        mergeTimeRange(cur);
//    }

    public List<TimeRange> mergeTimeRange(List<TimeRange> cur) {

        if (cur.size() == 1) {
            return cur;
        }

        cur.sort(((timeRange1, timeRange2) -> {
            return Integer.valueOf(timeRange1.getStart().substring(0,2)) < Integer.valueOf(timeRange2.getStart().substring(0,2)) ? -1 : 1;
        }));

//        cur.stream().sorted(Comparator.comparing(TimeRange::getStart));

        List<TimeRange> latest = new ArrayList<>();
        latest.add(cur.get(0));

        for (TimeRange timeRangeNode : cur) {
            if (Integer.valueOf(timeRangeNode.getStart().substring(0,2)) >= Integer.valueOf(latest.get(latest.size()-1).getStart().substring(0,2))
                    && Integer.valueOf(timeRangeNode.getStart().substring(0,2)) <= Integer.valueOf(latest.get(latest.size()-1).getEnd().substring(0,2))
                    && Integer.valueOf(timeRangeNode.getEnd().substring(0,2)) >= Integer.valueOf(latest.get(latest.size()-1).getEnd().substring(0,2))) {
                latest.get(latest.size()-1).setEnd(timeRangeNode.getEnd());
            }
            if (Integer.valueOf(timeRangeNode.getStart().substring(0,2)) >= Integer.valueOf(latest.get(latest.size() - 1).getEnd().substring(0,2))) {
                latest.add(timeRangeNode);
            }
        }

        return latest;
    }
}
