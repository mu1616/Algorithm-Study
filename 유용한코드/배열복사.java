	public int [][] copy(int [][]array){
		int [][]tmp = new int[array.length][array.length];
		for(int i=0; i< array.length; i++) {
			for(int j=0; j< array.length; j++) {
				tmp[i][j] = array[i][j];
			}
		}
		return tmp;
	}