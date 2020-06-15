import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main main = new Main();
		main.solution();
	}

	public void solution() {
		int n = scan.nextInt();
		int k = scan.nextInt();
		ArrayList<Country> list = new ArrayList<>();
		
		for(int i=0; i< n; i++) {
			list.add(new Country(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}
		
		Collections.sort(list);
		int result = 0;
		
		for(int i=0; i< n; i++) {
			if(list.get(i).num == k) {
				Country curr = list.get(i);
				int rank = i+1;
				int j = i-1;
				while(j>=0) {
					Country before = list.get(j);
					if(curr.gold == before.gold && curr.silver == before.silver && curr.bronze == before.bronze) {
						j--;
						rank--;
					} else {
						break;
					}
				}
				result = rank;
				break;
			}
		}
		System.out.println(result);
		
	}
	
	class Country implements Comparable<Country>{
		int num;
		int gold;
		int silver;
		int bronze;
		Country(int num, int gold, int silver, int bronze){
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		@Override
		public int compareTo(Country o) {
			if(this.gold > o.gold) {
				return -1;
			} else if(this.gold == o.gold) {
				if(this.silver > o.silver) {
					return -1;
				} else if(this.silver == o.silver) {
					if(this.bronze > o.bronze) {
						return -1;
					} else if(this.bronze == o.bronze) {
						return 0;
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
		@Override
		public String toString() {
			return "Country [num=" + num + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + "]";
		}
		
	}

}
