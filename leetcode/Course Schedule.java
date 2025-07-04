class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        int[] inDegrees = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            graph.putIfAbsent(prerequisite[1], new HashSet<>());
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees[prerequisite[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            count++;
            
            for (int linkedCourse : graph.getOrDefault(currentCourse, Collections.emptySet())) {
                inDegrees[linkedCourse]--;
                if (inDegrees[linkedCourse] == 0) {
                    queue.offer(linkedCourse);
                }
            }
        }
        
        return count == numCourses;
    }
}