import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportDetailMap = new HashMap<>();
        Map<String, Integer> reportCountMap = new HashMap<>();
        for (String id : id_list) {
            reportDetailMap.put(id, new HashSet<>());
            reportCountMap.put(id, 0);
        }
        for (String reportStr : report) {
            String user = reportStr.split(" ")[0];
            String target = reportStr.split(" ")[1];
            if (!reportDetailMap.get(user).contains(target)) {
                reportDetailMap.get(user).add(target);
                reportCountMap.put(target, reportCountMap.get(target) + 1);
            }
        }
        List<String> stopUsers = reportCountMap.entrySet().stream()
                .filter(e -> e.getValue() >= k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int i = 0; i < id_list.length; i++) {
            int mailCount = 0;
            for (String stopUser: stopUsers) {
                if (reportDetailMap.get(id_list[i]).contains(stopUser)) {
                    mailCount++;
                }
            }
            answer[i] = mailCount;
        }
        return answer;
    }
}