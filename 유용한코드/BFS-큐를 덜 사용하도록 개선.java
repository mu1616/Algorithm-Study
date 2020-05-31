//큐를 덜 사용하도록 개선
//큐에 넣는 순간 visited = true
//dfs에서는 가장 마지막노드부터 방문체크하기 때문에 스택에 넣는순간 방문여부를 따질 수 없지만,
//bfs에서는 먼저 넣은 정점을 먼저 방문 하므로 가능

void bfs(int node){
	boolean visited[max] = {false};
	front = rear = -1;
	visited[node] = true;
	queue[++rear] = node;  //enqueue
	
	while(front != rear) {
		int curr = queue[++front] //dequeue
		// visit curr node 
		// 큐에넣자마자 visit = true 하므로 한번 큐에 들어간 노드는 다시한번 큐에 들어가지 않는다.
		// 따라서 이부분에 방문했을 때, 로직을 넣어주면 된다.
		
		for(int next = 0; next < N; next++) {
			if(!visited[next] && graph[curr][next]) {
				visited[next] = true;  //먼저 넣은 정점 먼저 방문
				queue[++rear] = next;  //enqueue
			}
		}
	}
}