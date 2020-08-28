import java.util.*;

class Main {
	static Scanner scan = new Scanner(System.in);
	boolean flag = false;

	public static void main(String[] args) {
		Main main = new Main();
		for (int i = 0; i < 4; i++) {
			main.solution();
		}
	}

	public void solution() {
		flag = false;
		Team teams[] = new Team[6];

		for (int i = 0; i < 6; i++) {
			Team team = new Team();
			team.win = scan.nextInt();
			team.draw = scan.nextInt();
			team.lose = scan.nextInt();
			teams[i] = team;
		}

		recursion(teams, 0, 1);
		
		if (flag == true)
			System.out.print("1 ");
		else
			System.out.print("0 ");
	}

	public void recursion(Team[] teams, int me, int opp) {
		if (me == 5) {
			for(Team team : teams) {
				if(team.win != 0 || team.draw != 0 || team.lose != 0) {
					return;
				}
			}
			
			flag = true;
			return;
		}
		
		if (teams[me].win > 0 && teams[opp].lose > 0) {
			teams[me].win -= 1;
			teams[opp].lose -= 1;

			if (opp < 5)
				recursion(teams, me, opp + 1);
			else
				recursion(teams, me + 1, me + 2);

			teams[me].win += 1;
			teams[opp].lose += 1;
		}

		if (teams[me].draw > 0 && teams[opp].draw > 0) {
			teams[me].draw -= 1;
			teams[opp].draw -= 1;

			if (opp < 5)
				recursion(teams, me, opp + 1);
			else
				recursion(teams, me + 1, me + 2);

			teams[me].draw += 1;
			teams[opp].draw += 1;
		}

		if (teams[me].lose > 0 && teams[opp].win > 0) {
			teams[me].lose -= 1;
			teams[opp].win -= 1;

			if (opp < 5)
				recursion(teams, me, opp + 1);
			else
				recursion(teams, me + 1, me + 2);

			teams[me].lose += 1;
			teams[opp].win += 1;
		}
	}

	class Team {
		int win;
		int draw;
		int lose;
	}
}
