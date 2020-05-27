//DFS-  재귀
// N = 간선의 개수
// graph[][] == 인접행렬  ex)1번 3번 노드가 연결되어 있다면 graph[1][3] = 1 , graph[3][1] = 1  -> 무방향 행렬, 가중치는 모두 1
// visited[N] 은 false로 초기화
void dfs(int node) {
	visited[node] = true;
	//방문했을 때 연산//
	
	for(int next = 0; next < N; next++) {
		if(!visited[next] && graph[node][next] )
			dfs(next);
	}
}