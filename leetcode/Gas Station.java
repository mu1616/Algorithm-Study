class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        Integer startIndex = null;
        int tank = 0;
        int i = -1;
        int loopCount = 0;
        
        while (loopCount <= gas.length * 2) {
            loopCount++;
            i = (i + 1) % gas.length;
            if (startIndex != null && startIndex == i) {
                return startIndex;
            }

            if (startIndex == null) {
                if (gas[i] >= cost[i]) {
                    startIndex = i;
                } else {
                    continue;
                }
            }

            tank = tank + gas[i];
            boolean canGoNext = tank >= cost[i];
            if (canGoNext) {
                tank = tank - cost[i];
            } else {
                startIndex = null;
                tank = 0;
            }
        }
        return -1;
    }
}