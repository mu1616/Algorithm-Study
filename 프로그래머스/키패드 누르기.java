class Solution {
    private String[][] phone = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"*", "0", "#"}};
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Location leftHandLocation = new Location(0, 3);
        Location rightHandLocation = new Location(2, 3);
        for (int number : numbers) {
            Location numberLocation = getLocation(String.valueOf(number));
            if (number == 1 || number == 4 || number == 7) {
                answer = answer + "L";
                leftHandLocation = numberLocation;
                continue;
            }
            if (number == 3 || number == 6 || number == 9) {
                answer = answer + "R";
                rightHandLocation = numberLocation;
                continue;
            }
            int leftHandDistance = leftHandLocation.getDistance(numberLocation);
            int rightHandDistance = rightHandLocation.getDistance(numberLocation);
            if (leftHandDistance > rightHandDistance) {
                answer = answer + "R";
                rightHandLocation = numberLocation;
                continue;
            }
            if (leftHandDistance == rightHandDistance) {
                if (hand.equals("left")) {
                    answer = answer + "L";
                    leftHandLocation = numberLocation;
                } else {
                    answer = answer + "R";
                    rightHandLocation = numberLocation;
                }
                continue;
            }
            if (leftHandDistance < rightHandDistance) {
                answer = answer + "L";
                leftHandLocation = numberLocation;
                continue;
            }
        }
        return answer;
    }

    public Location getLocation(String key) {
        for (int i = 0; i < phone.length; i++) {
            for (int j = 0; j < phone[0].length; j++) {
                if (phone[i][j].equals(key)) {
                    return new Location(j, i);
                }
            }
        }
        throw new IllegalStateException();
    }

    public static class Location {
        int width;
        int height;

        public Location(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getDistance(Location location) {
            return Math.abs(width - location.width) + Math.abs(height - location.height);
        }
    }
}