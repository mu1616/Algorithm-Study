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

    public List sortByValue(HashMap<String,Integer> map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);
            }
        });
        return list;
    }
}