import java.util.*;

class Solution {
    HashMap<Character, Integer> map = new HashMap<>();
    char array[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    String [] data;
    int answer;
    public int solution(int n, String[] data) {
        this.data = data;

        permu(0, 8);
		
        return answer;
    }

    public void permu(int start, int r) {
        if(r == 0) { //base case
            for(int i = 0; i < array.length; i++) 
                map.put(array[i], i);     

            for(int i = 0; i < data.length; i++) {
                if(!isCorrect(data[i]))
                    return;
            }

            answer++;

        } else { //recursion
            for(int i = start; i < array.length; i++) {
                swap(i, start);
                permu(start + 1, r - 1);
                swap(i, start);
            }
        }
    }

    public void swap(int i, int j) {
        char tmp = array[i];
        array[i]= array[j];
        array[j] = tmp;
    }
	
	//주어진 간격에 맞는지 확인하는 함수
    public boolean isCorrect(String d) {
        char t1 = d.charAt(0);
        char t2 = d.charAt(2);
        char op = d.charAt(3);
        int n = d.charAt(4) - '0';
        int interval = Math.abs(map.get(t1) - map.get(t2)) - 1;

        if(op == '<') {
            if(interval < n)
                return true;
            else
                return false;

        } else if(op == '>') {
            if(interval > n)
                return true;
            else
                return false;

        } else if(op == '=') {                    
            if(interval == n) 
                return true;            
            else 
                return false;

        }

        return false;
    }
}