import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		int score[] = {5, 10, 9, 7, 6, 11, 13, 4};
		int wait[] = {0, 2, 0, 0, 2, 1, 0, 0};
		main.solution(score, wait);
	}
	
	public void solution(int score[], int wait[]) {
		int dp[] = new int[score.length];
		dp[0] = score[0];
		int answer = dp[0];
		for(int i=1; i< score.length; i++) {
			int max = score[i];
			for(int j=i; j>= 0; j--) {
				if(i - j - wait[j] >=1) {
					int t = dp[j] + score[i];
					if(max < t) 
						max = t;
				}
			}
			dp[i] = max;
			if(answer < max) 
				answer = max;
		}
		System.out.println(answer);
	}
	

}
/*
[3] 이번 주에는 지은이가 한학기 내내 연습하며 준비해 온 K-POP (Kyonggi-pop) Dancing
Contest 가 있다. 이 댄스 경연대회에서는 총 n 개의 음악을 주어진 순서대로 틀어주며 각
참가자는 자유롭게 춤을 추게 된다. 지은이는 그 n 개의 음악을 모두 알고 있으며, 심판들에 대한
정보와 자신의 춤 실력도 말도 안 될 정도로 너무나 잘 파악하고 있다. 그래서 i 번째 음악에
맞춰 지은이가 춤을 출 경우 정확히 Score[i]만큼의 점수를 얻게 된다는 것을 알고 있다. 다만,
i 번째 음악에 춤을 출 경우 체력적으로 힘들기 때문에 Wait[i]개 만큼의 다음 음악에는 춤을 출
수 없게 된다. (즉, i 번째 음악에 춤을 추면 i+1 번째에서 i+Wait[i] 번째 음악까지는 춤을 출 수
없다. 만약 Wait[i]=0 이면 쉼 없이 i+1 번째 음악에 춤을 출 수 있다.)
이 대회에서는 마지막 n 번째 음악까지 튼 후에, 제일 높은 점수를 얻은 댄서가 우승하게 된다.
지은이는 자신이 얻을 수 있는 최고 점수를 따고 싶다. 당신은 전공을 살려 지은이를 도와줄 수
있는 프로그램을 만들어 보기로 했다.
이 문제에서는 두 개의 배열 Score[1..n]와 Wait[1..n]이 입력으로 주어지며, 각 Score[i], Wait[i]는
0 이상의 정수로 주어진다고 가정하라. 지은이가 얻을 수 있는 최고점수를 계산하는 효율적인
알고리즘을 기술하고 분석하시오.
*/