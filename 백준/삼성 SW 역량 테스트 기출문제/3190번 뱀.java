import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int map[][];
	int headX = 0;
	int headY = 0;
	int tailX = 0;
	int tailY = 0;
	Stack<Integer> stack = new Stack<>();

	public static void main(String[] args){
		Main main = new Main();
		main.solution();
	}
	
	public void solution() {
		int n = scan.nextInt();
		map = new int[n][n];
		int k = scan.nextInt();
		
		for(int i = 0; i < k; i++)
			map[scan.nextInt() - 1][scan.nextInt() - 1] = 1;
		
		int l  = scan.nextInt();
		Queue<Direction> queue = new LinkedList<>();
		
		for(int i = 0; i < l; i++)
			queue.offer(new Direction(scan.nextInt(), scan.next().charAt(0)));
		
		int dx = 1;
		int dy = 0;
		map[0][0] = 2;
		int time = 0;
		int curveTime = queue.peek().x;
		char curveDirection = queue.peek().c;
		queue.poll();
		
		while(true) {
			time++;
			headX += dx;
			headY += dy;
			
			if(headX < 0 || headX >= n || headY < 0 || headY >= n)
				break;
			
			if(map[headY][headX] == 2)
				break;
			
			if(map[headY][headX] == 0) {  //사과 없음
				map[headY][headX] = 2;
				stack.push(headY * n + headX);
				map[tailY][tailX] = 0;
				reduceTail();
				
			} else if(map[headY][headX] == 1) {  //사과 있음
				map[headY][headX] = 2;
				stack.push(headY * n + headX);
			}
			
			if(time == curveTime) {
				//로직
				if(curveDirection == 'L') {
					if(dx == 1 && dy == 0) {
						dx = 0;
						dy = -1;
					} else if(dx == -1 && dy == 0) {
						dx = 0;
						dy = 1;
					} else if(dx == 0 && dy == 1) {
						dx = 1;
						dy = 0;
					} else if(dx == 0 && dy == -1) {
						dx = -1;
						dy = 0;
					}
						
				
				} else {
					if(dx == 1 && dy == 0) {
						dx = 0;
						dy = 1;
					} else if(dx == -1 && dy == 0) {
						dx = 0;
						dy = -1;
					} else if(dx == 0 && dy == 1) {
						dx = -1;
						dy = 0;
					} else if(dx == 0 && dy == -1) {
						dx = 1;
						dy = 0;
					}
				}
				//
				if(!queue.isEmpty()) {
					curveTime = queue.peek().x;
					curveDirection = queue.peek().c;
					queue.poll();
				}
			}
		}
		
		System.out.println(time);		
	}
	
	public void reduceTail() {
		tailY = stack.get(0) / map.length;
		tailX = stack.get(0) % map.length;
		stack.remove(0);
	}
	
	class Direction {
		int x;
		char c;
		
		Direction(int x, char c) {
			this.x = x;
			this.c = c;
		}
	}
}