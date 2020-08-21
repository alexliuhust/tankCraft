package tankCraft;

import java.util.Scanner;

public class Choose {
	
	// p1 is itself, p2 is the enemy.
	public static void chooseAndFire(Player p1, Player p2) {
		Scanner input = new Scanner(System.in);
		while(1==1) {
			System.out.println("What kind of shell you'd like to use (ap/at/he)?");
			String shell = input.next();
			
			if (shell.equals("ap")) {
				if (p1.APnum != 0) {
					AP.daM(p2, p1);
					break;
				}
				else {
					System.out.println("AP is run out! Choose another kind!"); 
					continue;
				}
			}
			else if (shell.equals("at")) {
				if (p1.ATnum != 0) {
					AT.daM(p2, p1);
					break;
				}
				else {
					System.out.println("AT is run out! Choose another kind!");
					continue;
				}
			}
			else if (shell.equals("he")) {
				if (p1.HEnum != 0) {
					HE.daM(p2, p1);
					break;
				}
				else {
					System.out.println("HE is run out! Choose another kind!");
					continue;
				}
			}
			else if (shell.equals("s")) {
				System.out.println("SKIP");
				break;
			}
			else System.out.println("Wrong input!");
		}
	}
}
