class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int front = 1;

        for(int i = 0; i < stations.length; i++) {
            int left = (stations[i] - w < 0) ? 0 : stations[i] - w ;
            int right = (stations[i] + w > n) ? n : stations[i] + w;

            answer += ((left - front - 1) / (double)(2 * w + 1)) + 1;

            front = right + 1;
        }

        answer += ((n + 1 - front - 1) / (double)(2 * w + 1)) + 1;

        return answer;
    }
}