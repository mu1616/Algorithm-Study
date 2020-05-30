import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int answer[][] = new int[9][9];
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}

	public void solution() {
		int k = scan.nextInt();
		char array[] = new char[k];
		for(int i=0; i< k; i++)
			array[i] = scan.next().charAt(0);
		
		System.out.println(makeMax(array));
		System.out.println(makeMin(array));
	}
	
	public String makeMax(char array[]) {
		ArrayList<Integer> list = new ArrayList<>();
		int k = 9;
		for(int i=0; i<= array.length; i++) {
			list.add(k);
			k--;
		}
		
		String result = "";
		for(int i=0; i< array.length; i++) {
			if(array[i] == '<') {
				int cnt = 0;
				for(int j=i+1; j< array.length; j++) {
					if(array[j] == '<') {
						cnt++;
					}else {
						break;
					}
				}
				result = result + String.valueOf(list.get(cnt+1));
				list.remove(cnt+1);
			}else {
				result = result + String.valueOf(list.get(0));
				list.remove(0);
			}
		}
		result = result + list.get(0);
		return result;
	}
	
	public String makeMin(char array[]) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<= array.length ; i++) {
			list.add(i);
		}
		String result = "";
		for(int i=0; i< array.length; i++) {
			if(array[i] == '<') {
				result = result + String.valueOf(list.get(0));
				list.remove(0);
			}else {
				int cnt = 0;
				for(int j=i+1; j< array.length; j++) {
					if(array[j] == '>') {
						cnt++;
					}else {
						break;
					}
				}
				result = result + String.valueOf(list.get(cnt+1));
				list.remove(cnt+1);
			}
		}
		result = result + list.get(0);
		return result;
	}
}