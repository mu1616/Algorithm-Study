import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int dx[] = {1, 1, 1, 0, 0, -1, -1, -1};
	int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    int ground[][];
	int nutrition[][];
	ArrayList<Tree> trees = new ArrayList<>();
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int n = scan.nextInt();
    	int m = scan.nextInt();
    	int k = scan.nextInt();
    	nutrition = new int[n][n];
    	ground = new int[n][n];
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			nutrition[i][j] = scan.nextInt();
    			ground[i][j] = 5;
    		}
    	}
    	
    	for(int i = 0; i < m; i++) {
    		int y = scan.nextInt();
    		int x = scan.nextInt();
    		int age = scan.nextInt();
    		trees.add(0, new Tree(x - 1, y - 1, age));
    	}
    	
    	for(int i = 0; i < k; i++) {
    		spring();
    		summer();
    		fall();
    		winter();
    	}
    	
    	System.out.println(trees.size());
    	
    }
    
    public void spring() {
    	for(Tree tree : trees) {
    		if(ground[tree.y][tree.x] < tree.age) {
    			tree.isLive = false;
    			//trees.remove(tree);
    		} else {
    			ground[tree.y][tree.x] -= tree.age; 
    			tree.age++;
    		}
    	}
    }
    
    public void summer() {
    	Iterator<Tree> it = trees.iterator();
    	while(it.hasNext()) {
    		Tree tree = it.next();
    		if(!tree.isLive) {
    			ground[tree.y][tree.x] += tree.age / 2;
    			it.remove();
    		}
    	}
    }
    
    public void fall() {
    	LinkedList<Tree> newTrees = new LinkedList<>();
    	for(Tree tree : trees) {
    		if(tree.age % 5 == 0) {
    			for(int j = 0; j < 8; j++) {
    				int nx = tree.x + dx[j];
    				int ny = tree.y + dy[j];
    				if(nx >= 0 && nx < ground.length && ny >=0 && ny < ground.length) {
    					newTrees.add(new Tree(nx, ny, 1));
    				}
    			}
    		}
    	}
    	trees.addAll(0, newTrees);
    }
    
    public void winter() {
    	for(int i = 0; i < ground.length; i++) {
    		for(int j = 0; j < ground.length; j++) {
    			ground[i][j] += nutrition[i][j];
    		}
    	}
    }
    
    class Tree {
    	int x;
    	int y;
    	int age;
    	boolean isLive;
    	Tree(int x, int y, int age) {
    		this.x = x;
    		this.y = y;
    		this.age = age;
    		isLive = true;
    	}
    }
}