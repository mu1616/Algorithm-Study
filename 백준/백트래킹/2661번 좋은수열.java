import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	ArrayList<String> list = new ArrayList<>();
	boolean stop;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		StringBuilder str = new StringBuilder("");
		recursion(str, n);
		
	}
	
	public void recursion(StringBuilder str, int n) {
		if(stop==true) {
			return;
		}
		if(str.length() == n) {
			System.out.println(str);
			stop = true;
		}
		str.append("1");
		if(isGood(str)) {
			recursion(str, n);
		}
		str.deleteCharAt(str.length()-1);
		str.append("2");
		if(isGood(str)) {
			recursion(str, n);
		}
		str.deleteCharAt(str.length()-1);
		str.append("3");
		if(isGood(str)) {
			recursion(str, n);
		}
		str.deleteCharAt(str.length()-1);
	}
	
	public boolean isGood(StringBuilder str ) {
		String copy = str.toString();
		if(copy.length() %2 !=0) {
			copy = copy.substring(1, copy.length());
		}
		for(int i=0; i< copy.length(); i=i+2) {
			//System.out.println(copy.substring(i, (i+copy.length())/2)+" "+copy.substring((i+copy.length())/2, copy.length()));
			if(copy.substring(i, (i+copy.length())/2).equals(copy.substring((i+copy.length())/2, copy.length()))){
				return false;
			}
		}
		//System.out.println(str);
		return true;
	}

}