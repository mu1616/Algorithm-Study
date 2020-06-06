import java.math.BigInteger;
import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	int array[];
	int result;
	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		array = {4, 2, 6, 3, 1, 5};
		int n = array.length;
		ArrayList<Integer> list = new ArrayList<>();


		list.add(array[0]);
		for(int i=1; i< n; i++) {  //가장 앞에있는 요소보다 작다면, 0번째 요소 교체
			if(list.get(0) > array[i]) {
				list.set(0, array[i]);
			}
			else if(list.get(list.size()-1) < array[i]) {   //가장 뒤에있는 요소보다 크다면 추가
				list.add(array[i]);
			}
			else {  //그 외 해당 요소가 들어갈 자리를 찾아 삽입이 아니라 교체!
				int k = Collections.binarySearch(list, array[i]);
				int idx = -(k+1);   // binarySearch 는 해당 요소가 없으면 해당 요소가 들어갈 자리의 인덱스를 idx라고 하면 -idx-1를 반환함
				list.set(idx, array[i]);
			}
		}
		System.out.println(list.size());  //lis 길이
		//단, 이때 list에 들어있는 요소는 lis의 구성 요소와 다르다!!!!! 단지 길이만 같음
		
	}

}

//그 외 DP, 백트래킹 등으로 풀 수있음. DP 는 O(n^2), 백트래킹(완전탐색)은 O(2^N) 
//DP로 풀때 부분문제 = 해당 인덱스를 끝으로 할때 나오는 LIS의 길이
//https://jins-dev.tistory.com/entry/%EC%B5%9C%EC%A0%81%ED%99%94%EB%90%9C-LISLongest-Increasing-Subsequence-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EA%B3%BC-%ED%95%B4-%EC%B0%BE%EA%B8%B0