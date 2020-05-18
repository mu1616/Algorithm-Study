/*
특정한 합을 가지는 부분 연속 수열 찾기  --> Prefix Sum 이용!!  (모든 배열의 원소가 양수일 때만 가능)
1. 시작점(start)과 끝점(end)이 첫번째 원소의 인덱스(0)을 가리키도록 한다.
2. 현재 부분합이 M과 같다면 카운트한다.
3. 현재 부분합이 M보다 작거나 같다면, end를 1 증가시킨다.
4. 현재 부분합이 M보다 크다면, start를 1 증가시킨다.
5. 모든 경우를 확인할 때까지 2번부터 4번까지의 과정을 반복한다.
시간복잡도 : 약 O(n)
*i=j일수도 있다.
*/
//부분연속 수열의 합이 M인 집합의 개수 찾기
import java.util.*;

class Main {
	static HashMap<Integer, Integer> map = new HashMap<>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int m = 5;
		int []data = {1,2,2,1,2,2,1,2,2,1,2,2,1,2,2};
		int start = 0;
		int end = 0;
		int count = 0;
		int sum = 0;
		sum = data[end];
		while(true) {
			if(sum == m) {
				count++;
			}
			if(sum <= m) {
				end = end + 1;
				if(end == data.length) break; 
				sum = sum + data[end];
			}else {
				sum = sum - data[start];   //start = start + 1 하기전에 sum에서 빼줘야함!!
				start = start + 1;
				if(start == data.length) break;				
			}
		}
		System.out.println(count);
	}

}

//Prefix Sum 을 이용해 구간합 빠르게 계산하기 문제에 적용 가능!
/*
1. M개의 [L,R] 정보가 주어진다. (L,R은 1부터 시작)
2. [L,R] 구간에 해당하는 데이터들의 합을 모두 구하려면?
시간제한 : O(N+M)
풀이 :
1. Prefix Sum을 계산하여 배열 P에 저장한다. 
-> array = {10,20,30,40,50} 이라면 P = {0,10,30,60,100,150} 
2. [L,R] = P[R] - P[L-1] 이다. (만약 L,R이 0부터 시작이라면 [L,R] = P[R+1] - P[L] )
*/