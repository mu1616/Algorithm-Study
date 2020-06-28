import java.util.*;

class Solution {
    ArrayList<Integer> resultList = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    String relation[][];

    public int solution(String[][] relation) {
        int answer = 0;
        int cols[] = new int[relation[0].length];
        this.relation = relation;

        for(int i=0; i< cols.length; i++)
            cols[i] = i;

        for(int i = 1; i<= cols.length; i++) 
            combi(cols, 0, i);

        //System.out.println(resultList.size());
        answer = resultList.size();
        return answer;
    }

    public void combi(int cols[], int start, int r) {
        if(r == 0) {
            if(!uniqueness()) {
                return;
            } else {
                int bitSum = 0;
                for(int i : stack) {
                    bitSum = bitSum + (int)Math.pow(2, i);
                }
                for(int i : resultList) {
                    if((i&bitSum) == i)
                        return;
                }
                resultList.add(bitSum);
            }
        } else {
            for(int i = start; i< cols.length; i++) {
                stack.push(cols[i]);
                combi(cols, i + 1 , r - 1);
                stack.pop();
            }
        }
    }

    public boolean uniqueness() {
        HashSet<String> set = new HashSet<>();

        for(int i=0; i< relation.length; i++) {
            StringBuilder sb = new StringBuilder("");

            for(int j=0; j< stack.size(); j++) 
                sb.append(relation[i][stack.get(j)]);       

            if(set.isEmpty())
                set.add(sb.toString());         
            else {
                if(set.contains(sb.toString())) 
                    return false;
                else 
                    set.add(sb.toString());
            }
        }

        return true;
    }
}