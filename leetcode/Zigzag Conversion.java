class Solution {
    
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[][] arr = new String[numRows][s.length()];
        int currentRow = 0;
        int currentCol = 0;
        boolean downMode = true;

        for (int i = 0; i < s.length(); i++) {
            String substr = s.substring(i, i + 1);
            arr[currentRow][currentCol] = substr;
            if (downMode) {
                if (currentRow < numRows - 1) {
                    currentRow++;
                } else {
                    downMode = false;
                    currentRow = currentRow - 1;
                    currentCol = currentCol + 1;
                }
                continue;
            }
            if (currentRow > 0) {
                currentRow = currentRow - 1;
                currentCol = currentCol + 1;
            } else {
                downMode = true;
                currentRow++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != null) {
                    result.append(arr[i][j]);
                }
            }
        }
        return result.toString();
    }
}