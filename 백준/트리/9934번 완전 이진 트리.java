import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException {
        int k = scanner.nextInt();
        int nodeCount = getNodeCount(k);
        Queue<Integer> dataQueue = new LinkedList<>();
        for (int i = 0; i < nodeCount; i++) {
            dataQueue.add(scanner.nextInt());
        }
        Tree tree = new Tree(k, dataQueue);
        tree.print();
    }

    public int getNodeCount(int k) {
        return (int) Math.pow(2, k) - 1;
    }

    static class Tree {
        private Node root;
        private Map<Integer, List<Integer>> levelDataMap = new HashMap<>();

        public Tree(int height, Queue<Integer> dataQueue) {
            this.root = createNode(1, height);
            this.inOrder(this.root, dataQueue);
        }

        private Node createNode(int currentHeight, int height) {
            Node node = new Node(currentHeight);
            if (currentHeight < height) {
                node.left = createNode(currentHeight + 1, height);
                node.right = createNode(currentHeight + 1, height);
            }
            return node;
        }

        public void inOrder(Node node, Queue<Integer> dataQueue) {
            if (node == null) {
                return;
            }
            inOrder(node.left, dataQueue);
            node.data = dataQueue.poll();
            levelDataMap.putIfAbsent(node.level, new ArrayList<>());
            levelDataMap.get(node.level).add(node.data);
            inOrder(node.right, dataQueue);
        }

        public void print() {
            for (int level : levelDataMap.keySet().stream().sorted().collect(Collectors.toList())) {
                for (int data : levelDataMap.get(level)) {
                    System.out.print(data + " ");
                }
                System.out.println();
            }
        }
    }

    static class Node {
        private int data;
        private int level;
        private Node left;
        private Node right;

        public Node(int level) {
            this.level = level;
        }
    }
}