class Solution {
    public int solution(int storey) {
        if (storey == 0) {
            return 0;
        }
        int answer = 0;
        int[] numbers = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

        int currentFloor = storey;
        for (int number : numbers) {
            int temp = currentFloor / number % 10;

            if (temp > 5) {
                int temp2 = 10 - temp;
                answer = answer + temp2;
                currentFloor = currentFloor + (number * temp2);
            } else if (temp == 5) {
                if (currentFloor / (10 * number) % 10 >= 5) {
                    currentFloor = currentFloor + (number * 5);
                } else {
                    currentFloor = currentFloor - (number * 5);
                }
                answer = answer + 5;
            } else {
                answer = answer + temp;
                currentFloor = currentFloor - (number * temp);
            }
            if (currentFloor == 0) {
                break;
            }
        }

        return answer;
    }
}