import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i< commands.length; i++) {
            answer[i] = getResult(array,commands[i]);
        }
        return answer;
    }

    public int getResult(int [] array, int [] command) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=command[0]-1; i< command[1]; i++) {
            list.add(array[i]);
        }
        Collections.sort(list);
        return list.get(command[2]-1);
    }
}