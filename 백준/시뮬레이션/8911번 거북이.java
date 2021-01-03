import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {0, 1, 0, -1};
	int dy[] = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Main main = new Main();
		int t = scan.nextInt();
		for (int i = 0; i < t; i++)
			main.solution();
	}

	public void solution() {
		List<Integer> xList = new ArrayList<>();
		List<Integer> yList = new ArrayList<>();
		String input = scan.next();
		int direction = 0;
		int x = 0;
		int y = 0;
		
		xList.add(0);
		yList.add(0);
		
		for(int i = 0; i < input.length(); i++) {
			char command = input.charAt(i);
			
			if (command == 'F') {
				x = x + dx[direction];
				y = y + dy[direction];
				xList.add(x);
				yList.add(y);
			}
			
			if (command == 'B') {
				x = x + dx[(direction + 2) % 4];
				y = y + dy[(direction + 2) % 4];
				xList.add(x);
				yList.add(y);
			}
			
			if (command == 'L') {
				direction = (direction + 3)  % 4;
			}
			
			if (command == 'R') {
				direction = (direction + 1) % 4;
			}
		}
		
		Collections.sort(xList);
		Collections.sort(yList);
		
		int answer = (xList.get(xList.size() - 1) - xList.get(0)) * (yList.get(yList.size() - 1) - yList.get(0));
		System.out.println(answer);
	}
}
