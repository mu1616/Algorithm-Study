import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer;
        ArrayList<Integer> resultList = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int idxCnt = 1;

        for(int i = 0; i< 26; i++) {
            char a = (char) (i + 'A');
            map.put(String.valueOf(a), idxCnt);
            idxCnt++;
        }

        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i< msg.length(); i++)
            queue.offer(msg.charAt(i));

        StringBuilder sb = new StringBuilder("");

        while(!queue.isEmpty()) { 
            char c = queue.poll();
            sb.append(c);

            if(map.containsKey(sb.toString())) {
                continue;
            } else {
                map.put(sb.toString(), idxCnt);
                idxCnt++;
                resultList.add(map.get(sb.substring(0, sb.length() - 1)));
                sb = new StringBuilder(String.valueOf(c));
            }           
        }

        resultList.add(map.get(sb.toString()));
        answer = new int[resultList.size()];

        for(int i = 0; i< answer.length; i++)
            answer[i] = resultList.get(i);

        return answer;
    }

}