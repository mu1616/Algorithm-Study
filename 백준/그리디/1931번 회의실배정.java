package algorithm;

import java.util.*;

class Main {
	static HashMap<Integer, Integer> map = new HashMap<>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		int n = scan.nextInt();
		int tmp = 0;
		int count = 0;
		ArrayList<Study> studyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Study study = new Study();
			study.start = scan.nextInt();
			study.end = scan.nextInt();
			studyList.add(study);
		}
		Collections.sort(studyList, new Study());
		for (int i = 0; i < studyList.size(); i++) {
			if (tmp <= studyList.get(i).start) {
				int endTime = studyList.get(i).end;
				tmp = endTime;
				count = count + 1;
			}
		}
		System.out.print(count);

	}

	static class Study implements Comparator<Study> {
		int start;
		int end;
		@Override
		public int compare(Study arg0, Study arg1) {
			int a = arg0.end;
			int b = arg1.end;
			if (a > b) {
				return 1;
			} else if (a < b) {
				return -1;
			} else {
				a = arg0.start;
				b = arg1.start;
				if(a > b) {
					return 1;
				}else if(a < b) {
					return -1;
				}else {
					return 0;
				}
			}
		}

	}
}