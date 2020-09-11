import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	Stack<Ingredient> stack = new Stack<>();
	int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

    public void solution() {
    	int n = scan.nextInt();
    	Ingredient ingredients[] = new Ingredient[n];
    	
    	for(int i = 0; i < n; i++) 
    		ingredients[i] = new Ingredient(scan.nextInt(), scan.nextInt());
    	
    	combi(ingredients, 0, n, 1, 0);
    	
    	System.out.println(min);
    }
    
    public void combi(Ingredient ingredients[], int start, int r, int s, int b) {
    	if(r != ingredients.length) {
	    	int diff = Math.abs(s - b);
	    	if(min > diff) min = diff;
    	}
    	
    	if(r == 0) {
    		return;
    	}
    	
    	for(int i = start; i < ingredients.length; i++) {
    		combi(ingredients, i + 1, r - 1, s * ingredients[i].s, b + ingredients[i].b);
    	}  	
    }

    class Ingredient {
    	int s;
    	int b;
    	Ingredient(int s, int b) {
    		this.s = s;
    		this.b = b;
    	}
    }
    
}