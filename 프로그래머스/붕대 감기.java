class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int bandCastingTime = bandage[0];
        int healPerSecond = bandage[1];
        int additionalHeal = bandage[2];
        int currentHp = health;
        int continuousHealCount = 0;
        int attackIndex = 0;

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            if (attacks[attackIndex][0] == i) {
                currentHp = currentHp - attacks[attackIndex][1];
                continuousHealCount = 0;
                attackIndex++;
                if (currentHp <= 0) {
                    return -1;
                }
                continue;
            }
            continuousHealCount++;
            currentHp = Math.min(health, currentHp + healPerSecond);
            if (continuousHealCount == bandCastingTime) {
                currentHp = Math.min(health, currentHp + additionalHeal);
                continuousHealCount = 0;
            }
        }
        return currentHp;
    }
}