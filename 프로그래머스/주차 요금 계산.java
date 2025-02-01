import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;


class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        int basicMinutes = fees[0];
        int basicFee = fees[1];
        double chargeMinutes = fees[2];
        int chargeFee = fees[3];

        Map<String, Integer> minutesSumMap = new HashMap<>();
        Map<String, LocalTime> timeMap = new HashMap<>();
        for (String record : records) {
            String[] split = record.split(" ");
            LocalTime time = LocalTime.parse(split[0]);
            String carNumber = split[1];
            String action = split[2];

            if (action.equals("IN")) {
                timeMap.put(carNumber, time);
            } else {
                LocalTime inTime = timeMap.get(carNumber);
                int minutesDiff = getMinutesDiff(inTime, time);
                minutesSumMap.merge(carNumber, minutesDiff, Integer::sum);
                timeMap.remove(carNumber);
            }
        }
        for (String carNumber : timeMap.keySet()) {
            LocalTime outTime = LocalTime.of(23, 59);
            int minutesDiff = getMinutesDiff(timeMap.get(carNumber), outTime);
            minutesSumMap.merge(carNumber, minutesDiff, Integer::sum);
        }

        List<String> sortedCarNumbers = minutesSumMap.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        int[] answer = new int[sortedCarNumbers.size()];
        for (int i = 0; i < answer.length; i++) {
            int minutesDiff = minutesSumMap.get(sortedCarNumbers.get(i));
            int fee = calcFee(minutesDiff, basicMinutes, basicFee, chargeMinutes, chargeFee);
            answer[i] = fee;
        }
        return answer;
    }

    private int getMinutesDiff(LocalTime inTime, LocalTime outTime) {
        return (60 * outTime.getHour() + outTime.getMinute()) - (60 * inTime.getHour() + inTime.getMinute());
    }

    private int calcFee(int minutesDiff, int basicMinutes, int basicFee, double chargeMinutes, int chargeFee) {
        if (minutesDiff <= basicMinutes) {
            return basicFee;
        }
        int extraFee = (int) Math.ceil((double) (minutesDiff - basicMinutes) / chargeMinutes) * chargeFee;
        return  basicFee + extraFee;
    }
}