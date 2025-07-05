class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        return search(root, word.toCharArray(), 0);
    }

    public boolean search(TrieNode startNode, char[] charArray, int index) {
        if (index == charArray.length) {
            return startNode.isEndOfWord();
        }
        char c = charArray[index];
        if (c != '.') {
            if (!startNode.children.containsKey(c)) {
                return false;
            }
            return search(startNode.children.get(c), charArray, index + 1);
        }
        for (TrieNode children : startNode.children.values()) {
            if (search(children, charArray, index + 1)) {
                return true;
            }
        }
        return false;
    }

    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();

        boolean endOfWord;

        public boolean isEndOfWord() {
            return endOfWord;
        }
    }
}