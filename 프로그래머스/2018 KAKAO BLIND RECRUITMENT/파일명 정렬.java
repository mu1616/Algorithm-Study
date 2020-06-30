import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<File> fileList = new ArrayList<>();

        for(int i = 0; i < files.length; i++) {
        	String str = files[i].toLowerCase();
        	File file = new File();
        	file.idx = i;
        	
        	int numberStartIdx = 0;
        	for(int j = 0; j< str.length(); j++) {
        		if(Character.isDigit(str.charAt(j))) {
        			file.head = str.substring(0, j);
        			numberStartIdx = j;
        			break;
        		}
        	}
        	
        	for(int j = numberStartIdx; j< str.length(); j++) {
        		if(!Character.isDigit(str.charAt(j))) {
        			file.number = Integer.parseInt(str.substring(numberStartIdx, j));
        			file.tail = str.substring(j, str.length());
        			break;
        		}
        		if(j == str.length() - 1) {
        			file.number = Integer.parseInt(str.substring(numberStartIdx, j + 1));
        		}
        	}
        	
        	fileList.add(file);
        }
        
        Collections.sort(fileList);
        
        for(int i=0; i< fileList.size(); i++)
        	answer[i] = files[fileList.get(i).idx];
        
        return answer;
    }
    
    
    class File implements Comparable<File>{
    	int idx;
    	String head;
    	int number;
    	String tail;

		@Override
		public int compareTo(File arg0) {
			if(this.head.compareTo(arg0.head) > 0) {
				return 1;
				
			} else if (this.head.compareTo(arg0.head) == 0) {
				if(this.number > arg0.number) {
					return 1;
					
				} else if(this.number == arg0.number) {
					if(this.idx > arg0.idx) {
						return 1;
						
					} else {
						return -1;
					}
					
				} else {
					return -1;
				}
				
			} else {
				return -1;
			}
		}	
    }
}