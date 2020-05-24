import java.util.*;
class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main m = new Main();
		m.solution();
	}
	
	public void solution() {
        int n = scan.nextInt();
        int m = scan.nextInt();
        char array[][] = new char[n][m];
        for(int i=0; i< n; i++) {
        	String tmp = scan.next();
        	for(int j=0; j< m; j++) {
        		array[i][j] = tmp.charAt(j);
        	}
        }
        printCharArray(array);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<= n-8; i++) {
        	for(int j=0; j<= m-8; j++) {
        		char copy[][] = copy(array,i,j);
        		int result = Math.min(fix1(copy,'W'),fix1(copy,'B'));
        		list.add(result);
        	}
        }
        Collections.sort(list);
        System.out.println(list.get(0));
        
    }
	
	public int fix1(char array[][], char start) {    
		int sum = 0;
		for(int i=0; i< 8; i++) {
			for(int j=0; j< 8; j++) {
				if(start =='W') {
					if(j%2 != 0) {
						if(array[i][j]=='W') {
							//array[i][j] = 'B';
							sum++;
						}
					} else {
						if(array[i][j]=='B') {
							//array[i][j] = 'W';
							sum++;
						}
					}
				} else if(start == 'B') {
					if(j%2 !=0) {
						if(array[i][j] == 'B') {
							//array[i][j] = 'W';
							sum++;
						}
					} else {
						if(array[i][j] == 'W') {
							//array[i][j] = 'B';
							sum++;
						}
					}
				}
			}
			if(start=='W') start = 'B';
			else start = 'W';
		}
		return sum;
	}
	
	public char[][] copy(char array[][], int x, int y){
		char copy[][] = new char[8][8];
		for(int i = 0; i< 8; i++) {
			for(int j = 0; j< 8; j++) {
				copy[i][j] = array[i+x][j+y];
			}
		}
		return copy;
	}
	
}