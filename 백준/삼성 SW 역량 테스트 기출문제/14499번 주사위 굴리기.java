import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {1, -1, 0, 0};
	int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		int k = scan.nextInt();
		int dice[] = new int[6];
		
		int map[][] = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = scan.nextInt();
			}
		}
		
		int arr[] = new int[k];
		for(int i = 0; i< k; i++)
			arr[i] = scan.nextInt();
		
		for(int i = 0; i < k; i++) {
			if(x + dy[arr[i] - 1] < 0 || x + dy[arr[i] - 1] >= n || y + dx[arr[i] - 1] < 0 || y + dx[arr[i] - 1] >= m)
				continue;
			
			x = x + dy[arr[i] - 1];
			y = y + dx[arr[i] - 1];
			
			switch(arr[i]) {
				case 1 : dice = east(dice); break;
				case 2 : dice = west(dice); break;
				case 3 : dice = north(dice); break;
				case 4 : dice = south(dice); break;
			}
			
			if(map[x][y] == 0) {
				map[x][y] = dice[5];
				
			} else {
				dice[5] = map[x][y];
				map[x][y] = 0;			
			}
			
			System.out.println(dice[0]);		
		}
		

	}
	
	public int[] east(int dice[]) {
		int newDice[] = new int[6];
		newDice[0] = dice[2];
		newDice[1] = dice[0];
		newDice[2] = dice[5];
		newDice[3] = dice[3];
		newDice[4] = dice[4];
		newDice[5] = dice[1];
		
		return newDice;
	}
	
	public int[] west(int dice[]) {
		int newDice[] = new int[6];
		newDice[0] = dice[1];
		newDice[1] = dice[5];
		newDice[2] = dice[0];
		newDice[3] = dice[3];
		newDice[4] = dice[4];
		newDice[5] = dice[2];
		
		return newDice;
	}
	
	public int[] south(int dice[]) {
		int newDice[] = new int[6];
		newDice[0] = dice[4];
		newDice[1] = dice[1];
		newDice[2] = dice[2];
		newDice[3] = dice[0];
		newDice[4] = dice[5];
		newDice[5] = dice[3];
		
		return newDice;
	}
	
	public int[] north(int dice[]) {
		int newDice[] = new int[6];
		newDice[0] = dice[3];
		newDice[1] = dice[1];
		newDice[2] = dice[2];
		newDice[3] = dice[5];
		newDice[4] = dice[0];
		newDice[5] = dice[4];
		
		return newDice;
	}
}