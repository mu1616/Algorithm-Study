import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] minutes = new int[1440];
        for (int i = 0; i < book_time.length; i++) {
            LocalTime startTime = LocalTime.parse(book_time[i][0]);
            LocalTime endTime = LocalTime.parse(book_time[i][1]);

            int startTotalMinutes = startTime.getHour() * 60 + startTime.getMinute();
            int endTotalMinutes = Math.min(endTime.getHour() * 60 + endTime.getMinute() + 10, 1439);
            minutes[startTotalMinutes] = minutes[startTotalMinutes] + 1;
            minutes[endTotalMinutes] = minutes[endTotalMinutes] - 1;
        }
        for (int i = 1; i < minutes.length; i++) {
            minutes[i] = minutes[i- 1] + minutes[i];
            answer = Math.max(answer, minutes[i]);
        }
        return answer;
    }
}