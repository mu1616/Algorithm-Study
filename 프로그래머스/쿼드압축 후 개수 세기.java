class Solution {
    
    public int[] solution(int[][] arr) {
        return compress(arr);
    }

    public int[] compress(int[][] arr) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0 ; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
        }
        if (zeroCount == 0) {
            return new int[]{0, 1};
        }
        if (oneCount == 0) {
            return new int[]{1, 0};
        }
        int[] result = {0, 0};
        int subArrLength = arr.length / 2;
        int[][] subArr1 = new int[subArrLength][subArrLength];
        int[][] subArr2 = new int[subArrLength][subArrLength];
        int[][] subArr3 = new int[subArrLength][subArrLength];
        int[][] subArr4 = new int[subArrLength][subArrLength];
        for (int i = 0; i < subArrLength; i++) {
            for (int j = 0; j < subArrLength; j++) {
                subArr1[i][j] = arr[i][j];
                subArr2[i][j] = arr[i][j + subArrLength];
                subArr3[i][j] = arr[i + subArrLength][j];
                subArr4[i][j] = arr[i + subArrLength][j + subArrLength];
            }
        }
        int[] compressResult1 = compress(subArr1);
        int[] compressResult2 = compress(subArr2);
        int[] compressResult3 = compress(subArr3);
        int[] compressResult4 = compress(subArr4);
        result[0] = compressResult1[0] + compressResult2[0] + compressResult3[0] + compressResult4[0];
        result[1] = compressResult1[1] + compressResult2[1] + compressResult3[1] + compressResult4[1];
        return result;
    }
}