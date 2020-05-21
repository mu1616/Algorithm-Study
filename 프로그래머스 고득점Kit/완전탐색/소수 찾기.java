import java.util.*;
class Solution {
    HashSet<Integer> primeList = new HashSet<>();
    public int solution(String numbers) {
		int answer = 0;
		String array[] = new String[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			array[i] = numbers.substring(i, i + 1);
		}
		for(int i=1; i< numbers.length()+1; i++) {
			permutation(array, 0, i, i);
		}
		answer = primeList.size();
		return answer;
	}
	
	public void permutation(String array[], int start, int r, int k) {
		if(r==0) {
			String str = "";
			for(int i=0; i< k; i++) {
				str = str + array[i];
				if(isPrime(Integer.parseInt(str)))
					primeList.add(Integer.parseInt(str));
			}
		}else {
			for(int i=start; i< array.length; i++) {
				swap(array, i, start);
				permutation(array, start+1, r-1, k);
				swap(array, i, start);
			}
		}
	}
	
	public void swap(String array[], int i, int j) {
		String tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public boolean isPrime(int n) {
		if(n==0 || n==1)
			return false;
		for(int i=2; i< n; i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}