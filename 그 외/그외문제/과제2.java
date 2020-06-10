import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		int a[] = {1, 3, 4, 6, 7, 10, 14, 15, 18};
		int x = 1;
		main.solution(a, x);
	}
	
	public void solution(int a[], int x) {
		int left = 1;
		int right = a.length;
		int answer = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(a[mid-1] < x) {
				left = mid + 1;
				answer = mid;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(answer + 1);
	}
}
/*
[2] 서로 다른 n 개의 실수(real number)가 배열 A[1…n]에 저장되어 있다. 여기서는 입력으로
주어지는 임의의 수 x 에 대한 순위인 sun(A, x)를 계산하는 문제를 생각한다.
정확하게 정의하자면 sun(A, x)는 배열 A 안에서 x 보다 작은 원소의 개수에 더하기 1 한
값이다.
예를 들어 배열 A 가 (4, 6, 1, 7, 3)과 같이 주어졌다면,
sun(A, 3) = 2, sun(A, 1) = 1, sun(A,5) = 4 이다.
(a) 입력으로 주어지는 배열 A 가 오름차순으로 정렬되어 있는 경우,
임의의 입력 x 에 대하여 sun(A, x)를 계산하는 효율적인 알고리즘을 기술하고 분석하시오.

*/