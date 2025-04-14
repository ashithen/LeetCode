package org.example.meta;

import java.util.*;

public class MeetingRoom {

    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        int curr = 0;
        int maxRoom = 0;

        while (i<intervals.length){
            if (start[i] == end[j]){
                i++; j++;
            } else if (start[i] < end[j]) {
                curr++;
                i++;
            }
            else {
                curr--;
                j++;
            }
            maxRoom = Math.max(maxRoom, curr);
        }
        return maxRoom;
    }
}
