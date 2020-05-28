//가중치가 없는 그래프에서는 BFS로 최단 경로를 구할 수 있다. 
//최단경로 = 어떤 노드에서 시작하여 목적지 노드를 방문하는 데 비용이 가장 적은 경로

void bfs(int node){
	boolean visited[max] = {false};
	dist[node] = 0;
	front = rear = -1;  //큐 초기화
	visited[node] = true;
	queue[++rear] = node;  //enqueue
	
	while(front != rear) {
		int curr = queue[++front]  //dequeue
		
		for(int next = 0; next < N; next++) {
			if(!visited[next] && graph[curr][next]) {
				visited[next] = true;
				dist[next] = dist[curr] + 1;   //자기까지 오는데 걸린 거리 + 1
				queue[++rear] = next;  //enqueue
			}
		}
	}
	
}