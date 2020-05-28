//DFS - 스택을 이용한 반복문
// input이 많을 때 사용 (재귀쓰면 스택오버플로우 일어날 때)
void dfs(int node) {
	boolean visited[] = new boolean[N];
	top = -1;
	stack[++top] = node;    //push
	while(top != -1) {
		int curr = stack[top--];   //pop
		if(!visited[curr]) {
			visited[curr] = true;
			//방문 했을 때 연산 //
		
			for(int next = 0; next < N; next++) {
				if(!visited[next] && graph[curr][next])
					stack[++top] = next;   //push 했다고 방문한건 아님 아직
			}
		}
	}
}
