//BFS 알고리즘

void bfs(int node){
	bool visited[max] = { false };
	front = rear = -1;
	queue[++rear] = node;   // enqueue
	
	while(front != rear) { //큐의 사이즈가 0이 아니라면
		int curr = queue[++front]   // dequeue
		if(!visited[curr]) {
			visited[curr] = true;
			//방문 했을 때 처리 //
			
			for(int next = 0; next < N; next++) {
				if(!visited[next] && graph[curr][next])
					queue[++rear] = next;  // enqueue
			}
		}			
	}
	
}