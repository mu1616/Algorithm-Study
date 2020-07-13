import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";      
        int currTime = 60 * 9;
        int j = 0;
        int cnt = 0;
		
        int time[] = new int[timetable.length];
		
		// timetable 정수배열로 변환 후 정렬
        for(int i = 0; i < time.length; i++) {
            String str[] = timetable[i].split(":");
            time[i] = 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        }

        Arrays.sort(time);
		
		// 버스에 태우기
        for(int i = 0; i < n; i++) {
            cnt = 0;

            while(j < time.length) {
                int arrive = time[j];

                if(arrive <= currTime && cnt < m) {
                    j++;
                    cnt++;

                } else {
                    break;
                }
            }           

            currTime += t;
        }
		
		// 결과
        int result = currTime - t;

        if(cnt == m) 
            result = time[j - 1] - 1;       

        String hours = String.valueOf(result / 60);
        if(hours.length() != 2)
            hours = "0"+hours;

        String min = String.valueOf(result % 60);
        if(min.length() != 2)
            min = "0"+min;

        answer = hours+":"+min;

        return answer;
    }
}