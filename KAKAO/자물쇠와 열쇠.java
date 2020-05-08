//Tip : 회전 후 열쇠가 맞을지 찾을 때, lock 배열의 크기를 3배 늘려서 하면 찾기 간편한다!
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        for(int i=0; i<4; i++) {
            key = revolve(key);
            if(scan(key, lock)) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    boolean scan(int [][]key, int [][]lock) {
        int tmp[][] = new int[lock.length*3][lock.length*3];
        for(int i=lock.length; i< lock.length*2; i++) {
            for(int j=lock.length; j< lock.length*2; j++) {
                tmp[i][j] = lock[i-lock.length][j-lock.length];
            }
        }
        /*
        for(int i=0; i< tmp.length; i++) {
            for(int j=0; j< tmp.length; j++) {
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
        */
        for(int i=0; i< tmp.length-(key.length-1); i++) {
            for(int j=0; j< tmp.length-(key.length-1); j++) {
                if(check(key, tmp, j,i)) return true;
            }
        }
        return false;
    }

    public boolean check(int [][]key, int [][]array, int startRow, int startCol) {
        int [][]tmp = copy(array);
        for(int i=startRow; i< startRow+key.length; i++) {
            for(int j=startCol; j< startCol+key.length; j++) {
                if(tmp[i][j] ==0 && key[i-startRow][j-startCol]==1) {
                    tmp[i][j] = 1;
                }else if(tmp[i][j]==1 && key[i-startRow][j-startCol]==1) {
                    tmp[i][j] = 0;
                }
            }
        }
        for(int i=tmp.length/3; i< tmp.length/3*2; i++) {
            for(int j=tmp.length/3; j< tmp.length/3*2; j++) {
                if(tmp[i][j]==0) return false;
                //System.out.print(tmp[i][j]+" ");
            }
            //System.out.println("");
        }
        //System.out.println("---");
        return true;
    }

    // NxN배열 시계방향 90도 회전
    public int[][] revolve(int[][] array) {
        int[][] array2 = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array2[i][j] = array[array.length-1 - j][i];
            }
        }
        return array2;
    }


    public int [][] copy(int [][]array){
        int [][]tmp = new int[array.length][array.length];
        for(int i=0; i< array.length; i++) {
            for(int j=0; j< array.length; j++) {
                tmp[i][j] = array[i][j];
            }
        }
        return tmp;
    }
}
