package tankCraft;

import java.util.Scanner;

public class MainGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		AngryMonkey p1 = new AngryMonkey();
		p1.name = "AngryMonkey";
		System.out.println("Please input the information of Player1");
		p1.setInfo();
		
		Blocker p2 = new Blocker();
		p2.name = "Blocker";
		System.out.println("Please input the information of Player2");
		p2.setInfo();
				
		System.out.println("How many rounds? ");
		int round = input.nextInt();
		System.out.println("*********************************************************");
		System.out.println("BEGIN!!");
		System.out.println("*********************************************************");
		p1.Dtaken = 0;
		p2.Dcuase = 0;
		
		out:
		for (int i = 1; i <= (2*round); i++) {
			
			System.out.println("\n");
			System.out.println("*****Round " + (i + 1) / 2 + "*****");
			System.out.println("\n--------------------------------------------------------");
			
			if (i % 2 == 1) {
				System.out.println(p1.name + "'s round:");
				p1.printInfo();
				if (p1.APnum == 0 && p1.ATnum == 0 && p1.HEnum == 0) {
					System.out.println("Your bay is empty!\nPlayer2 is the WINNER!!");
					break out;
				}
				
				p1.move();
				p1.active1(p1, p2);
				Choose.chooseAndFire(p1, p2);
				p2.passive2(p2, p1);
				if ((i + 1) % 6 == 0) p1.Nirvana(p1, p2);
				
				if (p2.HP <= 0) {
					System.out.println("Player1 is the WINNER!!");
					break out;
				}
			}
			
			if (i % 2 == 0) {
				System.out.println(p2.name + "'s round:");
				p2.printInfo();
				if (p2.APnum == 0 && p2.ATnum == 0 && p2.HEnum == 0) {
					System.out.println("Your bay is empty!\nPlayer1 is the WINNER!!");
					break out;
				}
				
				p2.move();
				p2.active1(p2, p1);
				Choose.chooseAndFire(p2, p1);
				p1.passive2(p1, p2);
				if (i % 6 == 0) p2.Nirvana(p2, p1);
				
				if (p1.HP <= 0) {
					System.out.println("Player2 is the WINNER!!");
					break out;
				}
			}

			if(i == 2*round && p1.HP != 0 && p2.HP != 0) {
				System.out.println("DRAW");
			}
					
		} //End the rounds
		System.out.println("END");
	}
}
