class Solution {
    public boolean wordPattern(String pattern, String s) {
        List<String> words = Arrays.stream(s.split(" "))
                .collect(Collectors.toList());

        List<String> patternChars = Arrays.stream(pattern.split(""))
                .collect(Collectors.toList());

        if (words.size() != patternChars.size()) {
            return false;
        }

        Map<String, String> patternToWord = new HashMap<>();
        Map<String, String> wordToPattern = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            String patternChar = patternChars.get(i);
            String matchingWord = patternToWord.get(patternChar);
            String matchingPattern = wordToPattern.get(word);

            if (matchingPattern == null && matchingWord == null) {
                patternToWord.put(patternChar, word);
                wordToPattern.put(word, patternChar);
                continue;
            }

            if (matchingPattern == null || matchingWord == null || !matchingPattern.equals(patternChar) || !matchingWord.equals(word)) {
                return false;
            }
        }

        return true;
    }
}