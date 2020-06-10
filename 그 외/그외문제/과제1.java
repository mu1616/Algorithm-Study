import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Main main = new Main();
		int k[] = {2, 4, 6, 8, 10};
		int s[] = {9, 3, 5, 7, 1};
		main.solution(k, s);
	}
	
	public void solution(int k[], int s[]) {
		int visited[] = new int[k.length];
		int result = 0;
		
		for(int i=0; i< s.length; i++) {
			int minDiff = 999999999;
			int idx = -1;
			for(int j=0; j< s.length; j++) {
				if(visited[j] == 0) {
					int diff = k[j] - s[i];
					if(diff > 0 && diff < minDiff) {
						minDiff = diff;
						idx = j;
					}
				}			
			}
			if(idx != -1) {
				visited[idx] = 1;
				result++;
			}
		}
		System.out.println(result);
	}
}
/*
[1] 국내 최대 규모의 프로그래밍 대회에서 경기대 팀은 S대와 결승전에서 맞붙게 되었다. 각
팀은 N명의 프로그래머들로 구성되어 있으며, 결승전에서는 각 선수가 한 번씩 출전하여 1:1로
경기를 벌여 승패를 결정하고, 최종적으로 더 많은 승리를 가져온 팀이 우승하게 된다. 각 팀은
결승전 전날, 주최측에 선수들의 출전 순서를 알려주어야 한다. 결승전 이틀 전, 경기대 팀
감독은 첩보를 통해 상대 S대 팀의 출전 순서를 알아내는 데 성공하였다. 문제를 간단하게 하기
위해 1:1 승부에서는 프로그래밍 실력이 높은 선수가 승리하고, 만약에 실력이 동일할 경우에는
경기대 팀이 진다고 가정한다.
경기대 팀의 팀원들의 실력은 배열 K에 K[1], K[2], …, K[N]의 양의 실수 값으로 주어지며, S대
팀의 팀원들의 실력은 배열 S에 S[1], S[2], …, S[N]의 양의 실수 값으로 주어진다. S대 팀원들의
출전 순서는 배열 S의 인덱스 순서와 같다고 가정한다. 이때 우리 경기대 팀이 출전 순서를
최선의 방법으로 정할 경우에 얻을 수 있는 승리의 최대 횟수는 얼마일까?
입력으로 배열 K[1..n]과 S[1..n]이 주어질 때 경기대 팀의 최대 승리 횟수를 출력하는 알고리즘을
기술하고 분석하시오.
(힌트) 이 문제는 greedy algorithm으로 해결할 수 있는 문제이다. 알고리즘을 기술하기 전에
greedy choice의 기준에 대해 설명하고 그것이 왜 옳은 방법인지 증명하거나 설명해야 한다.
/*