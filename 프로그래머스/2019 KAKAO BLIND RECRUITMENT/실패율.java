import java.util.*;

class Solution {
    static Scanner scan = new Scanner(System.in);
    Stack<Integer> stack = new Stack<>();

    public int[] solution(int n, int[] stages) {
        int[] answer = new int[n];
        Arrays.sort(stages);
        ArrayList<Fail> list = new ArrayList<>();

        int curr = 0;

        for (int i = 1; i <= n; i++) {
            int start = curr;
            stack.clear();

            while (curr < stages.length && stages[curr] == i) {
                stack.push(i);
                curr++;
            }

            if (start == stages.length) {
                list.add(new Fail(i, 0));
				
            } else {
                list.add(new Fail(i, (double)stack.size() / (double)(stages.length - start)));
            }

        }

        Collections.sort(list);

        for(int i=0; i< n; i++) {
            answer[i] = list.get(i).stage;
        }

        return answer;
    }

    class Fail implements Comparable<Fail>{
        int stage;
        double f;

        Fail(int stage, double f) {
            this.stage = stage;
            this.f = f;
        }

        @Override
        public int compareTo(Fail arg0) {
            if(this.f > arg0.f) {
                return -1;
            } else if(this.f == arg0.f) {
                if(this.stage > arg0.stage) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        }
    }

}