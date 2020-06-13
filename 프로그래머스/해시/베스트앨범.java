import java.util.*;
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Song> songList = new ArrayList<>();
        
        for(int i=0; i< genres.length; i++) {
        	songList.add(new Song(genres[i], plays[i], i));
        	if(map.containsKey(genres[i])) {
        		map.replace(genres[i], map.get(genres[i]) + plays[i]);
        	}else {
        		map.put(genres[i], plays[i]);
        	}
        }
        
        Collections.sort(songList);
        
        ArrayList<Integer> result = new ArrayList<>();
        
        int k = 1;
        result.add(songList.get(0).index);
        for(int i=1; i< songList.size(); i++) {
        	Song before = songList.get(i-1);
        	Song curr = songList.get(i);
        	if(before.genres.equals(curr.genres)) {
        		if(k < 2) {
        			k++;
        			result.add(curr.index);
        		} else {
        			k++;
        			continue;
        		}
        	} else {
        		k = 1;
        		result.add(curr.index);
        	}
        }
        
        int answer[] = new int[result.size()];
        for(int i=0; i< result.size(); i++)
        	answer[i] = result.get(i);
        
        return answer;
    }
		
	class Song implements Comparable<Song>{
		String genres;
		int play;
		int index;
		Song(String genres, int play, int index){
			this.genres = genres;
			this.play = play;
			this.index = index;
		}
				@Override
		public int compareTo(Song arg0) {
			if(map.get(this.genres) > map.get(arg0.genres)) {
				return -1;
			} else if(map.get(this.genres) == map.get(arg0.genres)) {
				if(this.play > arg0.play) {
					return -1;
				} else if(this.play == arg0.play) {
					if(this.index > arg0.index) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return 1;
				}
			}else {
				return 1;
			}
		}
		@Override
		public String toString() {
			return "Song [genres=" + genres + ", play=" + play + ", index=" + index + "]";
		}
		
		
	}
}