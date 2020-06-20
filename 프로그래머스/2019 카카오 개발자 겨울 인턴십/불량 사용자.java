import java.util.*;

class Solution {
    static Scanner scan = new Scanner(System.in);
    User users[];
    String bans[];
    int result;
    HashSet<Integer> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        bans = banned_id;
        users = new User[user_id.length];

        int bit = 1;

        for(int i=0; i< user_id.length; i++) {
            users[i] = new User(bit, user_id[i]);
            bit = bit * 2;
        }

        permu(0, banned_id.length);

        answer = result;
        return answer;
    }

    public void permu(int start, int r) {
        if(r == 0) {
            boolean same = true;
            int sum = 0;
            for(int i=0; i< bans.length; i++) {
                sum = sum + users[i].bit;
                if(!isPossible(users[i].id, bans[i])) {
                    same = false;
                    break;
                }
            }

            if(same && !set.contains(sum)) {
                result++;
                set.add(sum);
            }

        } else {
            for(int i=start; i< users.length; i++) {
                swap(start , i);
                permu(start+1, r-1);
                swap(start, i);
            }
        }
    }

    public void swap(int i, int j) {
        User tmp = users[i];
        users[i] = users[j];
        users[j] = tmp;
    }

    public boolean isPossible(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        for(int i=0; i< a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if(c1 != c2) {
                if(c2 != '*') {
                    return false;
                }
            }
        }
        return true;
    }

    class User {
        int bit;
        String id;
        User(int bit, String id){
            this.bit = bit;
            this.id = id;
        }
    }


}