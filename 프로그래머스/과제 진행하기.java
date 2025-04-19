import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public String[] solution(String[][] plans) {
        List<Plan> planObjectList = Arrays.stream(plans)
                .map(plan -> new Plan(plan[0], LocalTime.parse(plan[1]), Integer.valueOf(plan[2])))
                .sorted(Comparator.comparing(plan -> plan.startTime))
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();
        Stack<Plan> inProgressPlans = new Stack<>();

        for (Plan plan : planObjectList) {
            if (inProgressPlans.isEmpty()) {
                inProgressPlans.push(plan);
                continue;
            }
            
            int term = getTerm(inProgressPlans.peek().startTime, plan.startTime);
            int availableMinutes = term;

            while (!inProgressPlans.isEmpty()) {
                Plan previousPlan = inProgressPlans.peek();
                if (previousPlan.remainMinutes - availableMinutes > 0) {
                    previousPlan.remainMinutes = previousPlan.remainMinutes - availableMinutes;
                    break;
                }
                availableMinutes = availableMinutes - previousPlan.remainMinutes;
                inProgressPlans.pop();
                result.add(previousPlan.name);
            }

            inProgressPlans.push(plan);
        }

        while (!inProgressPlans.isEmpty()) {
            result.add(inProgressPlans.pop().name);
        }

        return result.toArray(String[]::new);
    }

    private int getTerm(LocalTime date1, LocalTime date2) {
        int min1 = (60 * date1.getHour()) + date1.getMinute();
        int min2 = (60 * date2.getHour()) + date2.getMinute();
        return Math.abs(min1 - min2);
    }

    public static class Plan {

        private String name;
        private LocalTime startTime;
        private int remainMinutes;

        public Plan(String name, LocalTime startTime, int remainMinutes) {
            this.name = name;
            this.startTime = startTime;
            this.remainMinutes = remainMinutes;
        }
    }
}