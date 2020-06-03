import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int block[][];
	int n;
	int max;
	ArrayList<Integer> resultList = new ArrayList<>();
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		n = scan.nextInt();
		block = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				block[i][j] = scan.nextInt();
			}
		}
		recursion(0, block);
		Collections.sort(resultList, Collections.reverseOrder());
		System.out.println(resultList.get(0));
	}
	
	public void recursion(int cnt, int [][]array) {
		if(cnt==5) {
			int max = 0;
			for(int i=0; i< n; i++) {
				for(int j=0; j< n; j++) {
					if(array[i][j] > max)
						max = array[i][j];
				}
			}
			resultList.add(max);
			//printBlock(array);
			//System.out.println();
			return;
		}
		//오른쪽
		recursion(cnt+1, right(copy(array)));
		//왼쪽
		recursion(cnt+1, left(copy(array)));
		//위
		recursion(cnt+1, up(copy(array)));
		//아래
		recursion(cnt+1, down(copy(array)));
	}
	
	public int[][] right(int [][]array) {
		int cache[][] = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=n-2; j>=0; j--) {
				for(int k=j+1; k< n; k++) {
					if(array[i][k]!=0 && array[i][k-1] == array[i][k] && cache[i][k] !=  i+1) {
						array[i][k] = array[i][k]*2;
						array[i][k-1] = 0;
						cache[i][k] = i+1;
						break;
					} else {
						if(array[i][k] == 0) {
							array[i][k] = array[i][k-1];
							array[i][k-1] = 0;
						} else {
							break;
						}
					}
				}
			}
		}
		return array;
	}
	
	public int[][] left(int [][]array) {
		int cache[][] = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=1; j< n; j++) {
				for(int k=j-1; k>= 0; k--) {
					if(array[i][k]!=0 && array[i][k+1] == array[i][k] && cache[i][k] != i+1) {
						array[i][k] = array[i][k]*2;
						array[i][k+1] = 0;
						cache[i][k] = i+1;
						break;
					} else {
						if(array[i][k] == 0) {
							array[i][k] = array[i][k+1];
							array[i][k+1] = 0;
						} else {
							break;
						}
					}
				}
			}
		}
		return array;
	}
	
	public int[][] up(int [][]array) {
		int cache[][] = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=1; j< n; j++) {
				for(int k=j-1; k>=0 ; k--) {
					if(array[k][i]!=0 && array[k+1][i] == array[k][i] && cache[k][i] != i+1) {
						array[k][i] = array[k][i]*2;
						array[k+1][i] = 0;
						cache[k][i] = i+1;
						break;
					} else {
						if(array[k][i] == 0) {
							array[k][i] = array[k+1][i];
							array[k+1][i] = 0;
						} else {
							break;
						}
					}
				}
			}
		}
		return array;
	}
	
	public int[][] down(int [][]array) {
		int cache[][] = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=n-2; j>=0; j--) {
				for(int k=j+1; k< n; k++) {
					if(array[k][i]!=0 && array[k-1][i] == array[k][i] && cache[k][i] !=  i+1) {
						array[k][i] = array[k][i]*2;
						array[k-1][i] = 0;
						cache[k][i] = i+1;
						break;
					} else {
						if(array[k][i] == 0) {
							array[k][i] = array[k-1][i];
							array[k-1][i] = 0;
						} else {
							break;
						}
					}
				}
			}
		}
		return array;
	}
	
	public void printBlock(int [][]block) {
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				System.out.print(block[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public int[][] copy(int [][]array){
		int [][]copy = new int[n][n];
		for(int i=0; i< n; i++) {
			for(int j=0; j< n; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}

}