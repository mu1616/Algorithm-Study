int k = 0;
static void setWall(int [][]array, int row, int col, int r) {
	if(r==0) {
		copyMap(array);
		//Spread(copy);
		System.out.println(++k);
		return;
	}
	int length = (n*m) - (m*row) - col;   // length = 배열의 길이, 즉 반복 횟수  12개중에 1개 뽑고 11개중에 뽑는다면, length는 11이 되야함
	for(int i=0; i< length; i++) {   //하나 뽑고 재귀 ( 0을 1로 바꾸고 그다음부분을 재귀로 )
		if(array[row][col]==0) {  
			array[row][col] = 1;
			if(col+1 < m) setWall(array, row, col+1, r-1);  
			else setWall(array, row+1, 0, r-1);  //col이 최대라면 row를 1개 올리고 col을 0으로 바꿈
			array[row][col] = 0;  //원상복구
		}
		if(col+1 < m) {
			col++;
		}else {
			row++;
			col = 0;
		}
	}
}
/*
문제 :
N X M 배열에서 요소가 0 인 것을 찾아 1로 바꿔라 단 3개만 바꿀 수 있다. 

0 0
0 0 이라면 1110, 1101, 1011, 0111 4가지 

즉, 4C3 과 같다.
	
	