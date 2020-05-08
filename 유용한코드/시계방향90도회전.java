	// NxN배열 시계방향 90도 회전
	public int[][] rotate(int[][] array) {
		int[][] array2 = new int[array.length][array[0].length];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array2[i][j] = array[array.length-1 - j][i];
			}
		}
		return array2;
	}