package algorithm;

import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int c = scan.nextInt();
    	int r = scan.nextInt();
    	int n = scan.nextInt();
    	Node nodes[] = new Node[n];
    	Node me = null;
    	// 좌표로 파싱
    	for(int i = 0; i < n + 1; i++) {
    		int a = scan.nextInt();
    		int b = scan.nextInt();
    		int x = 0;
    		int y = 0;
    		if(a == 1) {
    			y = r;
    			x = b;
    		} else if(a == 2) {
    			y = 0;
    			x = b;
    		} else if(a == 3) {
    			y = r - b;
    			x = 0;
    		} else if(a == 4) {
    			y = r - b;
    			x = c;
    		}
    		if(i < n)
    			nodes[i] = new Node(x, y);
    		else 
    			me = new Node(x, y);
    	}
    	//
    	// 계산
    	int sum = 0;
    	for(int i = 0; i < n; i++) {
    		if(nodes[i].x == me.x && (me.x == 0 || me.x == c)) {
    			sum += Math.abs(nodes[i].y - me.y);
    			continue;
    		}
    		
    		if(nodes[i].y == me.y && (me.y == 0 || me.y == r)) {
    			sum += Math.abs(nodes[i].x - me.x);
    			continue;
    		}
    		
    		if(Math.abs(nodes[i].x - me.x) == c) {
    			sum += (c + Math.min(nodes[i].y + me.y, (r - nodes[i].y) + (r - me.y)));
    			continue;
    		}
    		
    		if(Math.abs(nodes[i].y - me.y) == r) {
    			sum += (r + Math.min(nodes[i].x + me.x, (c - nodes[i].x) + (c - me.x)));
    			continue;
    		}
    		
    		sum += (Math.abs(nodes[i].x - me.x) + Math.abs(nodes[i].y - me.y));
    	}
    	
    	System.out.println(sum);
    }
    
    class Node {
    	int x;
    	int y;
    	Node(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	
    }
}