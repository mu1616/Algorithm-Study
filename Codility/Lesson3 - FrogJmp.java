class Solution {
	public int solution(int x, int y, int d) {
		return (y - x) % d == 0 ? (y - x) / d : (y - x) / d + 1;
	}
}