import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        ArrayList<Song> songList = new ArrayList<>();
        ArrayList<Song> resultList = new ArrayList<>();
    	m = m.replace("A#","1");
    	m = m.replace("C#","2");
    	m = m.replace("D#","3");
    	m = m.replace("F#","4");
    	m = m.replace("G#","5");
    	
        for(int i = 0; i< musicinfos.length; i++) {
        	String split[] = musicinfos[i].split(",");
        	Song song = new Song();
        	song.idx = i;
        	song.startHours = Integer.parseInt(split[0].split(":")[0]);
        	song.startMin = Integer.parseInt(split[0].split(":")[1]);
        	song.endHours = Integer.parseInt(split[1].split(":")[0]);
        	song.endMin = Integer.parseInt(split[1].split(":")[1]);
        	song.title = split[2];
        	song.melody = split[3];
        	song.melody = song.melody.replace("A#","1");
        	song.melody = song.melody.replace("C#","2");
        	song.melody = song.melody.replace("D#","3");
        	song.melody = song.melody.replace("F#","4");
        	song.melody = song.melody.replace("G#","5");
        	songList.add(song);
        }
        
        for(int i = 0; i< songList.size(); i++) {
        	Song song = songList.get(i);
        	int hoursDiff = song.endHours - song.startHours;
        	int minDiff = song.endMin - song.startMin;
        	int length = (hoursDiff*60) + minDiff;
        	song.length = length;
        	
        	ArrayList<String> soundList = new ArrayList<>();
        	for(int j = 0; j< song.melody.length(); j++) {
        		String sound = song.melody.substring(j, j+1);
        		soundList.add(sound);
        	}
			
        	StringBuilder sb = new StringBuilder("");
        	
        	for(int j = 0; j< length; j++) 
        		sb.append(soundList.get(j % soundList.size()));
        	      	
        	if(sb.toString().contains(m)) 
        		resultList.add(song);     	      	
        }
        
        Collections.sort(resultList);
		
        if(resultList.size() == 0) 
        	answer = "(None)";
        else
        	answer = resultList.get(0).title;
        
        return answer;
    }
    
    class Song implements Comparable<Song>{
    	int idx;
    	int startHours;
    	int startMin;
    	int endHours;
    	int endMin;
    	int length;
    	String title;
    	String melody;
		
		@Override
		public int compareTo(Song arg0) {
			if(this.length > arg0.length) {
				return -1;
			} else if(this.length == arg0.length) {
				if(this.idx > arg0.idx) {
					return 1;
				} else {
					return -1;
				}
			} else {
				return 1;
			}
		}
    	
    }
}