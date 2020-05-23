import java.util.*;
class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> wait = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;
        int end = 0;
        // 큐에 저장
        for (int n : truck_weights)
            wait.offer(n);
        for (int i = 0; i < bridge_length; i++)
            bridge.offer(0);

        while (true) {
            time++;
            totalWeight = totalWeight - bridge.poll();                  
            if(wait.size()==0) {
                end = 1;
                for(int n : bridge) {
                    if(n>0) end = 0;
                }
                if(end==1) break;
            }
            if (wait.size() > 0 && totalWeight + wait.peek() <= weight) {
                int n = wait.poll();
                bridge.offer(n);
                totalWeight = totalWeight + n;
            }else {
                bridge.offer(0);
            }
        }
        answer = time;
        return answer;
    }
}