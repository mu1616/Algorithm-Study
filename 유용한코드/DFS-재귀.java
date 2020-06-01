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
	//만약 여기에 visited[node] = false 를 쓴다면, 시간소모가 엄청 커지게됨!! 
	//왜냐면 node를 통해서 탐색을 모두 완료했는데, 또다시 탐색을 하기 때문
	//ex) 1 -> 2 -> .... 탐색 완료 이후에   3 -> 2 -> 를 통한 탐색도 하게됨! 
	//이미 2를거쳐서 가는 탐색은 완료했으므로 할 필요가 없다!
	// 
}