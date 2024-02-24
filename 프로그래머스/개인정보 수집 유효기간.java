import java.util.*;
import java.util.stream.*;

class Solution {
    
    private static final int DAY_OF_MONTH = 28;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        String[] todaySplit = today.split("\\.");
        int todayNum = (DAY_OF_MONTH * 12 * Integer.parseInt(todaySplit[0])) + (DAY_OF_MONTH * Integer.parseInt(todaySplit[1])) + Integer.parseInt(todaySplit[2]);
        Map<String, Integer> termsMap = Arrays.stream(terms)
                .collect(Collectors.toMap(t -> t.split(" ")[0], t -> Integer.parseInt(t.split(" ")[1])));

        for (int i = 0; i < privacies.length; i++) {
            String[] privacySplit = privacies[i].split(" ");
            String[] dateSplit = privacySplit[0].split("\\.");
            int dayNum = (DAY_OF_MONTH * 12 * Integer.parseInt(dateSplit[0])) + (DAY_OF_MONTH * Integer.parseInt(dateSplit[1])) + Integer.parseInt(dateSplit[2]);
            int expiredDayNum = dayNum + (termsMap.get(privacySplit[1]) * DAY_OF_MONTH) - 1;
            if (todayNum > expiredDayNum) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(n -> n).toArray();
    }
}