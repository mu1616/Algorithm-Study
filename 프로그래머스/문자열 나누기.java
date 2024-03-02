    public int solution(String s) {
        int answer = 0;
        int firstIndex = 0;
        char[] sArray = s.toCharArray();
        while (true) {
            if (firstIndex < s.length()) {
                answer++;
            }
            char firstChar = sArray[firstIndex];
            int xCnt = 1;
            int notXCnt = 0;
            boolean split = false;
            for (int i = firstIndex + 1; i < sArray.length; i++) {
                char currentChar = sArray[i];
                if (firstChar == currentChar) {
                    xCnt++;
                } else {
                    notXCnt++;
                }

                if (xCnt == notXCnt && i <= s.length() - 1) {
                    firstIndex = i + 1;
                    split = true;
                    break;
                }
            }
            if (!split) {
                break;
            }
        }
        return answer;
    }