import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.replace("{","");
        s = s.replace("}","");
        String [] array = s.split(",");
        HashMap<String,Integer> map = new HashMap<>();
        for(String temp : array){
            if(map.containsKey(temp)) {
                int t = map.get(temp);
                map.put(temp,t+1);
            }else {
                map.put(temp,1);
            }
        }
        int answer[] = new int[map.size()];
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int length = answer.length;
            String temp = (String)iterator.next();
            answer[length - map.get(temp)] = Integer.parseInt(temp);
        }
        return answer;
    }

}