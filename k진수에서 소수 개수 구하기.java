    public int solution(int n, int k) {
        int answer = 0;
        String convertNum = convert(n, k);
        String[] nums;
        if (convertNum.contains("0")) {
            nums = convertNum.split("0");;
        } else {
            nums = new String[]{convertNum};
        }
        for (String num : nums) {
            if (num.equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(num))) {
                answer++;
            }
        }
        return answer;
    }

    public String convert(int n, int k) {
        if (n == 0) {
            return "0";
        }
        String result = "";
        int v = n;
        while (true) {
            if (v < k) {
                result = v + result;
                break;
            }
            result = (v % k) + result;
            v = v / k;
        }
        return result;
    }

    public boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        int sqrtNum = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtNum; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }