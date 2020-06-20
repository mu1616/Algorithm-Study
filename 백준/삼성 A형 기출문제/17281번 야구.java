import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[][];
	int max;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {      
        int n = scan.nextInt();
        array = new int[n][9];
        
        for(int i=0; i< n; i++) {
        	for(int j=0; j< 9; j++) {
        		array[i][j] = scan.nextInt();
        	}
        }
        
        Player players[] = new Player[8];
        int j = 0;
        for(int i=0; i< 9; i++, j++) {
        	if(i == 0) {
        		j--;
        		continue;
        	}
        	players[j] = new Player(i);
        }
        
        permu(players, 0, 8);
        
        System.out.println(max);    
    }
	
	public void permu(Player players[], int start, int r) {
		if(r ==0) {
			ArrayList<Player> playerList = new ArrayList<>(Arrays.asList(players));
			playerList.add(3, new Player(0));
			
			baseball(playerList);
		}else {
			for(int i = start; i< players.length; i++) {
				swap(players, start, i);
				permu(players, start + 1, r - 1);
				swap(players, start, i);
			}
		}
	}
	
	public void swap(Player players[], int i, int j) {
		Player tmp = players[i];
		players[i] = players[j];
		players[j] = tmp;
	}
	
	public void baseball(ArrayList<Player> playerList) {
		int score = 0;
		int curr = 0;
		for(int i=0; i< array.length; i++) {
			int out = 0;
			
			int base[] = new int[3];
			
			while(out < 3) {
				int k = array[i][playerList.get(curr).idx];
				if(k != 0) {
					for(int j=2; j>=0 ; j--) {
						if(j + k >= 3 && base[j] == 1) {
							score++;
							base[j] = 0;
						} else if(j + k < 3 && base[j] == 1){
							base[j] = 0;
							base[j + k] = 1;
						}
					}
					if(k == 4)
						score++;
					else {
						base[k-1] = 1;
					}
				} else {
					out++;
				}	
				curr = (curr + 1) % 9;   //다음 주자
			}
		}
		
		if(max < score)
			max = score;
	}

	
	class Player {
		int idx;
		Player(int idx) {
			this.idx = idx;
		}
		
	}
}