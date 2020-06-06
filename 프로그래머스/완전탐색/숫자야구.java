class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        int []numbers = new int[1000];
        for(int i=100; i< numbers.length; i++) {
            if(i/100 != i%100/10 && i/100 != i%10 && i%100/10 != i%10) {
                if(i/100 != 0 && i%100/10 != 0 && i%10 !=0)
                numbers[i] = 1;
            }
            //System.out.println(i+" "+numbers[i]);
        }
        for(int i=0; i< baseball.length; i++) {
            int num = baseball[i][0];
            int s = baseball[i][1];
            int b = baseball[i][2];
            cal(numbers, num, s, b);
        }
        for(int i=100; i< 1000; i++) {
            if(numbers[i] == 1) {
                answer++;
            }
        }
        return answer;
    }

    public void cal(int []numbers, int num, int s, int b) {
        int digit[][] = new int[3][2];
        for(int i=100; i< 1000; i++) {
            int tmp_s = s;
            int tmp_b = b;
            if(numbers[i]==1) {
                digit[0][0] = i/100;
                digit[0][1] = num/100;
                digit[1][0] = i%100/10;
                digit[1][1] = num%100/10;
                digit[2][0] = i%10;
                digit[2][1] = num%10;
                if(digit[0][0] == digit[0][1]) {
                    tmp_s--;
                }else if(digit[0][0] == digit[1][1] || digit[0][0] == digit[2][1]){
                        tmp_b--;
                }
                if(digit[1][0] == digit[1][1]) {
                    tmp_s--;
                } else if(digit[1][0] == digit[0][1] || digit[1][0] == digit[2][1]) {
                    tmp_b--;
                }
                if(digit[2][0] == digit[2][1]) {
                    tmp_s--;
                } else if(digit[2][0] == digit[1][1] || digit[2][0] == digit[0][1]) {
                    tmp_b--;
                }
            }
            if(!(tmp_s == 0 && tmp_b ==0))
                numbers[i] = 0;
        }
    }
}