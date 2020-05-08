class Solution {
    public String solution(String p) {
        String answer = recursion(p);
        return answer;
    }

    public String recursion(String p) {
        if(p.equals("")) {
            return "";
        }
        int i = findBalancedString(p);
        String u = p.substring(0,i+1);
        String v = p.substring(i+1, p.length());
        if(isRightString(u)) {
            return u + recursion(v);
        }
        else {
            String tmp = "";
            tmp = tmp + "(";
            tmp = tmp + recursion(v);
            tmp = tmp + ")";
            u = u.substring(1,u.length()-1);            
            u = u.replace(')','1');
            u = u.replace('(','2');
            u = u.replace('1', '(');
            u = u.replace('2', ')');
            tmp = tmp + u;
            return tmp;
        }
    }

    public int findBalancedString(String p) {
        int cnt = 0;   // ( 개수
        int cnt2 = 0;  // ) 개수
        int result = 0;
        for(int i=0; i< p.length(); i++) {
            if(p.charAt(i)=='(') {
                cnt++;
            }else {
                cnt2++;
            }
            if(i>=1 && cnt==cnt2) {
                result = i;
                break;
            }
        }
        return result;
    }

    // p는 균형잡힌 문자열이라고 가정!
    boolean isRightString(String p) {
        int count = 0;
        if(p.charAt(0)==')') return false;
        for(int i=0; i< p.length(); i++) {
            if(p.charAt(i)=='(')
                count++;
            else
                count--;
            if(count < 0)
                return false;
        }
        return true;
    }
}