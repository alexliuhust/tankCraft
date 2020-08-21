package tankCraft;

import java.util.Scanner;

public class Blocker extends Player {

	Scanner input = new Scanner(System.in);
	int RCTnum = 4;
	
	// Reinforce
	public void active1(Player p1, Player p2) {
		if (HP > 75) {
			System.out.println("Cast the Reinforce? (y)");
			String trigger = input.next();
			if (trigger.equals("y")) {
				double rand = Math.random();
				HP -= (int)(75.0 - rand * 20.0);
				RCTnum += 3;
				System.out.println("Reinforced (" + RCTnum +"left)");
			}
		}
		
	}
	
	public void passive1(Player p1, Player p2) {
		
	}
	
	// Reactive armor
	public void passive2(Player p1, Player p2) {
		if (Dtaken != 0 && RCTnum != 0) {
			double rand = Math.random();
			if (rand <= RCTnum * 0.2) {
				RCTnum--;
				HP += Dtaken;
				System.out.println("Reactive armor triggered! (" + RCTnum +"left)");
			}
		}
		else if (Dtaken == 0 && RCTnum == 0) {
			double rand = Math.random();
			if (rand <= 0.1) {
				RCTnum++;
				System.out.println("Reactive armor reinforced");
			}
		}
	}
	
	// Directional blasting
	public void Nirvana(Player p1, Player p2) {
		if (RCTnum != 0) {
			System.out.println("Cast the Directional blasting? (y)");
			String trigger = input.next();
			if (trigger.equals("y")) {
				RCTnum = 0;
				int x1 = p1.position[0];
				int y1 = p1.position[1];
				int x2 = p2.position[0];
				int y2 = p2.position[1];
				double dis = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
				dis = Math.pow(dis, 0.5);
				int dam;
				if (dis <= 5.0) {
					dam = (int)(35.0 * RCTnum - dis * dis);
					System.out.println("Directional blasting " + dam + " !!");
				}
				else {
					dam = 1;
				}
				p2.HP -= dam;
				p1.Dcuase += dam;
				p2.Dtaken += dam;
			}
		}
	}
	
	
	
	
	
}
