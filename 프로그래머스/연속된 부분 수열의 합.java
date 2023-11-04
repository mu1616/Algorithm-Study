import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<Value> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while (true) {
            if (sum == k) {
                list.add(new Value(left, right));
                left++;
                if (left > right) {
                    break;
                }
                sum = sum - sequence[left - 1];
            } else if (sum > k) {
                left++;
                if (left > right) {
                    break;
                }
                sum = sum - sequence[left - 1];
            } else if (sum < k) {
                right++;
                if (right >= sequence.length) {
                    break;
                }
                sum = sum + sequence[right];
            }
        }
        Collections.sort(list, (v1, v2) -> {
            if (v1.getLength() == v2.getLength()) {
                return v1.start - v2.start;
            }
            return v1.getLength() - v2.getLength();
        });
        int[] answer = {list.get(0).start, list.get(0).end};
        return answer;
    }
    
    public static class Value {
        int start;
        int end;
        
        public Value(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int getLength() {
            return this.end - this.start;
        }
    }
}