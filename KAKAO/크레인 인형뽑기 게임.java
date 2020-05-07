import java.util.*;
class Solution {
    ArrayList<Integer> basket = new ArrayList<>();
    int answer = 0;
    public int solution(int[][] board, int[] moves) {
        for(int i=0; i<moves.length; i++){
            choice(board, moves[i]);
        }
        return answer;
    }

    void choice(int [][]board, int move){
        int column = move - 1;
        for(int i=0; i < board.length ; i++){
            if (board[i][column] !=0 ) {
                basket.add(board[i][column]);
                board[i][column] = 0;
                if(checkSame() == true)                   
                    answer = answer + 2;    
                break;
            }
        }
    }
    boolean checkSame(){
        int size = basket.size();
        if(size>1 && (basket.get(size-1) == basket.get(size-2))){
            System.out.println(basket.get(size-1)+" "+basket.get(size-2));
            basket.remove(size-1);
            basket.remove(size-2);
            return true;
        }
        return false;
    }
}