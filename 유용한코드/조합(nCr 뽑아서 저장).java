//
//
//
import java.lang.reflect.Array;
import java.util.Stack;
//n개의 배열요소중에 r 개를 뽑아서 result[][]에 저장
public class Combination {
	int row = 0;
	String[][] result;	//뽑아서 저장할 배열

	public static void main(String[] args) {
		Combination c = new Combination();
		c.solution();

	}

	public void solution() {
		int r = 4; //뽑을 개수
		String[] user_id = { "frodo", "fradi", "crodo","abc123", "frodoc" }; //뽑을 배열
		result = new String[combinationCount(user_id.length,r)][r];
		Stack<Integer> st = new Stack<Integer>();
		pick(user_id, st, r);
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<r; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

	void pick(String array[], Stack<Integer> st, int r) {
		if (r == 0)
			insert(st, array);
		int smallest = st.isEmpty() ? 0 : st.lastElement() + 1;
		for (int next = smallest; next < array.length ; next++) {
			st.push(next);
			pick(array, st, r - 1);
			st.pop();

		}

	}
	
	
	//스택에 있는 요소들 따로 배열로 저장
	void insert(Stack<Integer> st, String[] array) {
		int i=0;
		for(int t : st) {
			result[row][i] = array[t];
			i++;
		}
		row++;
	}

	// 조합 수
	int combinationCount(int n, int r) {
		if (r == 0 || r == n)
			return 1;
		else
			return combinationCount(n - 1, r - 1) + combinationCount(n - 1, r);
	}
	

}
