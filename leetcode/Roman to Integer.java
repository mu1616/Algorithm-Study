class Solution {
    
    public int romanToInt(String s) {
        Map<String, Integer> map = Map.of(
                "I", 1,
                "V", 5,
                "X", 10,
                "L", 50,
                "C", 100,
                "D", 500,
                "M", 1000
        );
        int sum = map.get(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            String beforeSymbol = s.substring(i - 1, i);
            String currentSymbol = s.substring(i, i + 1);
            if (((currentSymbol.equals("V") || currentSymbol.equals("X")) && beforeSymbol.equals("I")) ||
                    ((currentSymbol.equals("L") || currentSymbol.equals("C")) && beforeSymbol.equals("X")) ||
                    ((currentSymbol.equals("D") || currentSymbol.equals("M")) && beforeSymbol.equals("C"))) {
                sum = sum + map.get(currentSymbol) - (map.get(beforeSymbol) * 2);
            } else {
                sum = sum + map.get(currentSymbol);
            }
        }
        return sum;
    }
}