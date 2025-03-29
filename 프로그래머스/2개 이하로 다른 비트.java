class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = calculate(numbers[i]);
        }
        return answer;
    }

    public long calculate(long number) {
        if (number % 4 != 3) {
            return number + 1;
        }
        String binaryString = "0" + Long.toBinaryString(number);
        char[] arr = binaryString.toCharArray();
        for (int i = 0; i < binaryString.length(); i++) {
            if (arr[arr.length - i - 1] == '0') {
                arr[arr.length - i - 1] = '1';
                arr[arr.length - i] = '0';
                break;
            }
        }
        return Long.parseLong(new String(arr), 2);
    }
}