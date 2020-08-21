package tankCraft;

import java.util.Scanner;

public class AngryMonkey extends Player{
	
    Scanner input = new Scanner(System.in);
    
    // Cannon-ball fuel
	public void active1(Player p1, Player p2) {
		System.out.println("Cast the Cannon-ball fuel? (y)");
		String trigger = input.next();
		if (trigger.equals("y")) {
			if (APnum != 0) {
				APnum--;
				speed += 3;
				move();
				speed -= 3;
			} 
			else if (ATnum != 0) {
				ATnum--;
				speed += 3;
				move();
				speed -= 3;
			} 
			else {
				HEnum--;
				speed += 3;
				move();
				speed -= 3;
			}
		}	
		
	}
	
	// Counter-attack
	public void passive2(Player p1, Player p2) {
		if (Dtaken !=0) {
			double rand = Math.random();
			if (rand <= 0.25) {
				System.out.println("AngryMonkey's Counterattack!");
				Choose.chooseAndFire(p1, p2);
			}
		}
	}
	
	// Crazy hunt
	public void Nirvana(Player p1, Player p2) {
		System.out.println("Cast the Crazy hunt? (y)");
		String trigger = input.next();
		if (trigger.equals("y")) {
			System.out.print("Take my anger!\t");
			double rand = Math.random() * 3;
			if (rand <= 1.0) {APnum += 3; System.out.println("AP +3 !");} 
			else if (rand <= 2.0) {ATnum += 3; System.out.println("AT +3 !");} 
			else {HEnum += 3; System.out.println("HE +3 !");} 
			Choose.chooseAndFire(p1, p2);
			rand = Math.random() * 3;
			if (rand <= 2.0) Choose.chooseAndFire(p1, p2);
			if (rand <= 1.0) Choose.chooseAndFire(p1, p2);
		}
	}
	
	
}
