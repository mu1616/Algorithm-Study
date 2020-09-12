import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	HashSet<Character> set = new HashSet<>();
	String strs[];
	int max = 0;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int n = scan.nextInt();
    	int k = scan.nextInt();
    	strs = new String[n];
    	for(int i = 0; i < n; i++) strs[i] = scan.next();
    	set.add('a');
    	set.add('n');
    	set.add('t');
    	set.add('i');
    	set.add('c');
    	char arr[] = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};
    	
    	combi(arr, 0, k - 5);
    	
    	System.out.println(max);
    }
    
    public void combi(char arr[], int start, int r) {
    	if(r == 0) {
    		int cnt = 0;
    		for(String str : strs) {
        		boolean possible = true;
    			for(int i = 0; i < str.length(); i++) {
    				if(!set.contains(str.charAt(i))) {
    					possible = false;
    					break;
    				}
    			}
    			
    			if(possible) cnt++;
    		}

    		if(max < cnt) max = cnt;
    		return;
    	}
    	
    	for(int i = start; i < arr.length; i++) {
    		set.add(arr[i]);
    		combi(arr, i + 1, r - 1);
    		set.remove(arr[i]);
    	}
    }
}
