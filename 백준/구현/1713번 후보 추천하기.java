import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
    
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}
	
    public void solution() {
    	int n = scan.nextInt();
    	int k = scan.nextInt();
    	int arr[] = new int[k];
    	for(int i = 0; i < k; i++) arr[i] = scan.nextInt();
    	int pictures[] = new int[101];
    	ArrayList<Integer> list = new ArrayList<>();
    	HashSet<Integer> set = new HashSet<>();
    	
    	for(int i = 0; i < arr.length; i++) {
    		int num = arr[i];
    		
    		if(set.contains(num)) {
    			pictures[num]++;
    			
    		} else {
    			if(list.size() < n) {
    				set.add(num);
    				list.add(num);
    				pictures[num]++;
    				
    			} else {
    				int min = getMin(list, pictures);
    				removeMin(list, pictures, set, min);
    				set.add(num);
    				list.add(num);
    				pictures[num]++;
    			}
    		}
    	}
    	
    	Collections.sort(list);
    	for(int i : list) System.out.print(i+" ");

    }
    
    public void removeMin(ArrayList<Integer> list, int pictures[], HashSet<Integer> set, int min) {
    	for(int i = 0; i < list.size(); i++) {
    		int n = list.get(i);
    		if(min == pictures[n]) { 
    			list.remove(i);
    			set.remove(new Integer(n));
    			pictures[n] = 0;
    			break;
    		}
    	}
    }
    
    public int getMin(ArrayList<Integer> list, int pictures[]) {
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < list.size(); i++) {
    		int n = list.get(i);
    		if(min > pictures[n])
    			min = pictures[n];
    	}
    	
    	return min;
    }
}