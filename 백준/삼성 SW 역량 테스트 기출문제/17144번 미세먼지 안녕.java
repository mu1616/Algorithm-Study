package algorithm;

import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {1, -1, 0, 0};
	int dy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int r = scan.nextInt();
    	int c = scan.nextInt();
    	int t = scan.nextInt();
    	int map[][] = new int[r][c];
    	int robot[] = new int[2];
    	int cnt = 0;
    	for(int i = 0; i < r; i++) {
    		for(int j = 0; j < c; j++) {
    			map[i][j] = scan.nextInt();
    			if(map[i][j] == -1) robot[cnt++] = i;
    		}
    	}

    	for(int i = 0; i < t; i++) {
    		int renewMap[][] = spread(map);
    		int renewMap2[][] = new int[r][c];

    		right(renewMap, renewMap2, robot[0]);
    		up(renewMap, renewMap2, robot[0], 0, c - 1);
    		left(renewMap, renewMap2, 0);
    		down(renewMap, renewMap2, 0, robot[0] - 1, 0);

    		right(renewMap, renewMap2, robot[1]);
    		down(renewMap, renewMap2, robot[1], r - 1, c - 1);
    		left(renewMap, renewMap2, r - 1);
    		up(renewMap,renewMap2, r - 1, robot[1] + 1, 0);

    		for(int j = 1; j < robot[0]; j++) {
    			for(int k = 1; k < c - 1; k++) {
    				renewMap2[j][k] = renewMap[j][k];
    			}
    		}
    		
    		for(int j = robot[1] + 1; j < r - 1; j++) {
    			for(int k = 1; k < c - 1; k++) {
    				renewMap2[j][k] = renewMap[j][k];
    			}
    		}
    		renewMap2[robot[0]][0] = -1;
    		renewMap2[robot[1]][0] = -1;
    		//print(renewMap2);
    		map = renewMap2;
    	}
    	
    	int sum = 0;
    	for(int i = 0; i < map.length; i++) {
    		for(int j = 0; j < map[0].length; j++) {
    			if(map[i][j] != -1) sum += map[i][j];
    		}
    	}
    	System.out.println(sum);
    }
    
    public int [][] spread(int map[][]) {
    	int renewMap[][] = new int[map.length][map[0].length];
    	
    	for(int i = 0; i < map.length; i++) {
    		for(int j = 0; j < map[0].length; j++) {
    			if(map[i][j] >= 5) {
    				int cnt = 0;
    				for(int k = 0; k < 4; k++) {
    					int nx = j + dx[k];
    					int ny = i + dy[k];
    					
    					if(nx >=0 && nx < map[0].length && ny >= 0 && ny < map.length) {
    						if(map[ny][nx] != -1) {
    							renewMap[ny][nx] += map[i][j] / 5;
    							cnt++;
    						}
    					}
    				}
    				
    				renewMap[i][j] = renewMap[i][j] + (map[i][j] - ((map[i][j] / 5) * cnt));
    			} else {
    				renewMap[i][j] += map[i][j];
    			}
    		}
    	}
    	
    	return renewMap;
    }
    
    public void up(int map[][], int renewMap[][], int startY, int endY, int x) {
    	for(int i = endY; i < startY; i++) {
    		renewMap[i][x] = map[i + 1][x];
    	}
    }
    
    public void down(int map[][], int renewMap[][], int startY, int endY, int x) {
    	for(int i = endY; i > startY; i--) {
    		renewMap[i][x] = map[i - 1][x];
    	}
    }
    
    public void left(int map[][], int renewMap[][], int y) {
    	for(int i = 0; i < map[0].length - 1; i++) {
    		renewMap[y][i] = map[y][i + 1];
    	}
    }
    
    public void right(int map[][], int renewMap[][], int y) {
    	for(int i = map[0].length - 1; i > 1; i--) {
    		renewMap[y][i] = map[y][i - 1];
    	}
    }
    
    public void print(int [][]map) {
    	for(int i = 0; i < map.length; i++) {
    		for(int j = 0; j < map[0].length; j++) {
    			System.out.print(map[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}