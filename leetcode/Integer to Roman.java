class Solution {

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        List<Integer> sortedKeyList = map.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        int i = sortedKeyList.size() - 1;
        while (num > 0) {
            int key = sortedKeyList.get(i);
            int n1 = num / key;
            if (n1 != 0) {
                result.append(map.get(key));
                num = num - key;
            } else {
                i--;
            }
        }
        return result.toString();
    }
}