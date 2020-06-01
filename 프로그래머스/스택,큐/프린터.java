import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		int []priorities = {1,1,9,1,1,1};
		int location = 0;
		main.solution(priorities, location);
	}
	public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Paper> queue = new LinkedList<>();
        ArrayList<Paper> list = new ArrayList<>();
        for(int i=0; i< priorities.length; i++) {
        	Paper p = new Paper(priorities[i], i);
        	queue.offer(p);
        	list.add(p);
        }
        int cnt = 0;
        while(true) {
        	Paper paper = queue.poll();
        	boolean check = true;
        	for(Paper p : queue) {
        		if(p.p > paper.p)
        			check = false;
        	}
        	if(check) {
        		cnt++;
        		if(paper.location == location) break;
        	}else {
        		queue.offer(paper);
        	}
        }
        answer = cnt;
        System.out.println(answer);
        return answer;
    }
	
	class Paper{
		int p;
		int location;
		Paper(int p, int location){
			this.p = p;
			this.location = location;
		}	

	}
	
}