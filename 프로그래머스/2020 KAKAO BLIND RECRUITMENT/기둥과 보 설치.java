import java.util.*;

class Solution {
    HashSet<Integer> pillarSet = new HashSet<>();  //기둥을 꽂은 위치 (아래)
    HashSet<Integer> beamSet = new HashSet<>(); //보를 설치한 위치 (왼쪽)
    int n;    
	
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        this.n = n;

        for(int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int what = build_frame[i][2];
            int how = build_frame[i][3];

            if(what == 0) {
                if(how == 1) {
                    buildPillar(x, y);

                } else {
                    deletePillar(x, y);
                }

            } else {
                if(how == 1) {
                    buildBeam(x, y);

                } else {
                    deleteBeam(x, y);
                }
            }
        }

        ArrayList<Frame> frameList = new ArrayList<>();

        for(int i : pillarSet)
            frameList.add(new Frame(i % (n + 1), i / (n + 1), 0));

        for(int i : beamSet)
            frameList.add(new Frame(i % (n + 1), i / (n + 1), 1));

        Collections.sort(frameList);

        answer = new int[frameList.size()][3];

        for(int i = 0; i < answer.length; i++) {
            answer[i][0] = frameList.get(i).x;
            answer[i][1] = frameList.get(i).y;
            answer[i][2] = frameList.get(i).what;
        }

        return answer;
    }

    public void buildPillar(int x, int y) {
        int location = y*(n + 1) + x;

        if(y == 0 || beamSet.contains(location) || pillarSet.contains(location - (n + 1))) {
            pillarSet.add(location);
            return;
        }

        if(x > 0 && beamSet.contains(location - 1)) {
            pillarSet.add(location);
            return;
        }

    }

    public void deletePillar(int x, int y) {
        int location = y*(n + 1) + x;

        if(beamSet.contains(location + (n + 1))) {
            if((!beamSet.contains(location + (n + 1) + 1) || !beamSet.contains(location + (n + 1) - 1)) 
                    && !pillarSet.contains(location + 1))
                return;
        }

        if(beamSet.contains(location + (n + 1) - 1)) {
            if((!beamSet.contains(location + (n + 1)) || !beamSet.contains(location + (n + 1) - 2)) 
                    && !pillarSet.contains(location - 1))
                return;
        }

        if(pillarSet.contains(location + (n + 1))) {
            if(!beamSet.contains(location + (n + 1)) && !beamSet.contains(location + (n + 1) - 1))
                return;
        }       

        pillarSet.remove(new Integer(location));
    }

    public void buildBeam(int x, int y) {
        int location = y*(n + 1) + x;

        if((!pillarSet.contains(location - (n + 1)) && !pillarSet.contains(location - (n + 1) + 1))
                && (!beamSet.contains(location - 1) || (!beamSet.contains(location + 1)))) {
            return;
        }

        beamSet.add(location);
    }

    public void deleteBeam(int x, int y) {
        int location = y*(n + 1) + x;

        if(pillarSet.contains(location)) {
            if(!pillarSet.contains(location - (n + 1)) && !beamSet.contains(location - 1))
                return;
        }

        if(pillarSet.contains(location + 1)) {
            if(!pillarSet.contains(location - (n + 1) + 1) && !beamSet.contains(location + 1))
                return;
        }

        if(beamSet.contains(location - 1)) {
            if(!pillarSet.contains(location - (n + 1) - 1) && !pillarSet.contains(location - (n + 1)))
                return;
        }

        if(beamSet.contains(location + 1)) {
            if(!pillarSet.contains(location - (n + 1) + 1) && !pillarSet.contains(location - (n + 1) + 2))
                return;         
        }

        beamSet.remove(new Integer(location));
    }

    class Frame implements Comparable<Frame>{
        int x;
        int y;
        int what;

        Frame(int x, int y, int what) {
            this.x = x;
            this.y = y;
            this.what = what;
        }

        @Override
        public int compareTo(Frame arg0) {
            if(this.x > arg0.x) {
                return 1;
            } else if(this.x == arg0.x) {
                if(this.y > arg0.y) {
                    return 1;
                } else if(this.y == arg0.y) {
                    if(this.what > arg0.what) {
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