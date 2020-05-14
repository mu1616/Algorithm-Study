import java.util.*;

class Solution {
	
	public int[] solution(int[] answers) {
        int[] answer;
        ArrayList<Student> list = new ArrayList<>();
        Student student[] = new Student[3];
        int tmp[]  = {1,2,3,4,5};
        student[0] = new Student(1, new int[] {1,2,3,4,5});
        student[1] = new Student(2, new int[] {2,1,2,3,2,4,2,5});
        student[2] = new Student(3, new int[] {3,3,1,1,2,2,4,4,5,5});
        list.add(student[0]);
        list.add(student[1]);
        list.add(student[2]);
        for(int i=0; i< answers.length; i++) {
        	if(answers[i]==student[0].array[i%student[0].array.length]) student[0].count++ ;
        	if(answers[i]==student[1].array[i%student[1].array.length]) student[1].count++;
        	if(answers[i]==student[2].array[i%student[2].array.length]) student[2].count++;
        }
        Collections.sort(list);
        int count = 1;
        for(int i=1; i< list.size(); i++) {
        	if(list.get(i).count == list.get(i-1).count) {
        		count++;
        	}else {
        		break;
        	}
        }
        answer = new int[count];
        for(int i=0; i<count; i++) {
        	answer[i] = list.get(i).num;
        }
        
        return answer;
    }
	
	class Student implements Comparable<Student>{
		int num;
		int count;
		int array[];
		
		Student(int num,int array[]){
			this.num = num;
			this.array = array;
		}

		@Override
		public int compareTo(Student arg0) {
			if(this.count > arg0.count) {
				return -1;
			}else if(this.count < arg0.count) {
				return 1;
			}else {
				return 0;
			}
			
		}
	}

}