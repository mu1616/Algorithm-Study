//Dynamic Programming !! 
class Solution {

    public int solution(int [][]board) {
        int answer = 0;     

        for(int i = 0; i < board[0].length; i++)
            answer = (answer > board[0][i]) ? answer : board[0][i];     

        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    int min = Math.min(Math.min(board[i][j-1], board[i-1][j-1]), board[i-1][j]);
                    board[i][j] = min + 1;
                    answer = (answer > board[i][j]) ? answer : board[i][j];
                }
            }
        }

        return answer * answer;
    }
}