class Solution {
    public boolean isPalindrome(String s) {
        Set<String> availableAlphanumeric = Arrays.stream("0123456789AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".split(""))
                .collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String substr = s.substring(i, i + 1);
            if (availableAlphanumeric.contains(substr)) {
                sb.append(substr.toLowerCase());
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}