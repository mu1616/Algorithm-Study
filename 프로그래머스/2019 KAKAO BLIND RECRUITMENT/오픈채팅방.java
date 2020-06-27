import java.util.*;

class Solution {
    HashMap<String, String> userInfo = new HashMap<>();

    public String[] solution(String[] record) {
        String[] answer;
        ArrayList<Message> mList = new ArrayList<>();

        for(int i=0; i< record.length; i++) {
            String split[] = record[i].split(" ");

            if(split[0].equals("Enter")) {
                Message m = new Message();
                m.message = "님이 들어왔습니다.";
                m.id = split[1];
                mList.add(m);

                if(userInfo.containsKey(split[1]))
                    userInfo.replace(split[1], split[2]);
                else
                    userInfo.put(split[1], split[2]);

            } else if(split[0].equals("Leave")) {
                Message m = new Message();
                m.message = "님이 나갔습니다.";
                m.id = split[1];
                mList.add(m);

            } else if(split[0].equals("Change")) {
                userInfo.replace(split[1], split[2]);
            }
        }

        answer = new String[mList.size()];
        int i = 0;
        for(Message m : mList) {
            answer[i] = userInfo.get(m.id)+m.message;
            i++;
        }

        return answer;
    }

    class Message {
        String message;
        String id;
    }

}
