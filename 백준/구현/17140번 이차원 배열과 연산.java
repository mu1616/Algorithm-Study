import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int r = scan.nextInt() - 1;
		int c = scan.nextInt() - 1;
		int k = scan.nextInt();
		int arr[][] = new int[100][100];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		
		if(arr[r][c] == k) {
			System.out.println("0");
			return;
		}
		
		int rowLength = 3;
		int colLength = 3;
		
		int time = 0;
		while(time < 100) {
			if(rowLength >= colLength) {
				for(int i = 0; i < rowLength; i++) {
					arr[i] = R(arr[i]);
				}
				
				colLength = calcColLength(arr);
				
			} else if(rowLength < colLength) {
				for(int i = 0; i < colLength; i++) {
					int newArr[] = C(arr, i);
					for(int j = 0; j < 100; j++) arr[j][i] = newArr[j];
				}
				
				rowLength = calcRowLength(arr);
			}

			time++;
			
			if(arr[r][c] == k) {
				System.out.println(time);
				return;
			}
		}
		
		System.out.println(-1);
	}
	
	public int calcRowLength(int arr[][]) {
		int rowLength = 0;
		for(int i = 0; i < 100; i++) {
			int acc = 0;
			for(int j = 0; j < 100; j++) {
				if(arr[j][i] != 0) acc++;
			}
			if(rowLength < acc) rowLength = acc;
		}
		
		return rowLength;
	}
	
	public int calcColLength(int arr[][]) {
		int colLength = 0;
		for(int i = 0; i < 100; i++) {
			int acc = 0;
			for(int j = 0; j < 100; j++) {
				if(arr[i][j] != 0) acc++;
			}
			if(colLength < acc) colLength = acc;
		}
		
		return colLength;
	}
	
	public int[] R(int arr[]) {
		int newArr[] = new int[100];
		Item items[] = new Item[100];
		
		for(int i = 0; i < 100; i++) 
			items[i] = new Item(i + 1, 0);
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) continue;
			items[arr[i] - 1].count++;
		}
		
		Arrays.sort(items);

		int index = 0;
		for(int i = 0; i < 100; i++) {
			Item item = items[i];
			
			if(item.count == 0 || index >= newArr.length) break;
			
			newArr[index++] = item.num;
			newArr[index++] = item.count;
		}
		
		return newArr;
	}
	
	public int[] C(int arr[][], int col) {
		int newArr[] = new int[100];
		Item items[] = new Item[100];
		
		for(int i = 0; i < 100; i++) 
			items[i] = new Item(i + 1, 0);
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][col] == 0) continue;
			items[arr[i][col] - 1].count++;
		}
		
		Arrays.sort(items);
		
		int index = 0;
		for(int i = 0; i < 100; i++) {
			Item item = items[i];
			
			if(item.count == 0 || index >= newArr.length) break;
			
			newArr[index++] = item.num;
			newArr[index++] = item.count;
		}
		
		return newArr;
	}
	
	class Item implements Comparable<Item>{
		int num;
		int count;
		Item (int index, int count) {
			this.num = index;
			this.count = count;
		}
		@Override
		public int compareTo(Item arg0) {
			if(this.count == 0 || arg0.count == 0) return arg0.count - this.count;
			if(this.count == arg0.count) return this.num - arg0.num;
			return this.count - arg0.count;
		}	
	}
}