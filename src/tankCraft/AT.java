package tankCraft;

import java.util.Scanner;

public class AT {
	// px is the victim, py is the shooter.
	public static void daM(Player px, Player py) {
		int Dam = 0;
		Scanner input = new Scanner(System.in);
		py.ATnum -= 1;
		
		System.out.print("Please input the shooting degree: ");
		double degree = input.nextDouble();
		String Deter = Calculate.calculateR(py, px, degree);
		
		if (Deter.equals("y")) {
			double rand = 100 * Math.random();
			double prob = 0;
			prob = -1.6 * Math.pow(px.Arm,2) + 74;
			if (rand <= prob) {
				Dam = (int) (80 - (px.Arm * px.Arm/5.0*6.0));
				Dam = Dam + (int)(10 * Math.random() - 5);
				System.out.println("Armor Penetration!!");
			}
			else {
				Dam = (int) (30 - px.Arm * px.Arm / 2);
				Dam = Dam + (int)(28 * Math.random() - 14);
				System.out.println("Frontal Explosion");
			}
			px.HP -= Dam;
			px.Dtaken = Dam;
			py.Dcuase = Dam;
			System.out.println("Damage: " + Dam);
		}
		else {
			System.out.println("MISS");
			
		}
		
		double armbrk;
		double anti = Math.random();
		if (anti <= 0.075 && Dam > 0) {
			armbrk = 0.4;
			System.out.println("Armor Breaking!!");
		}
		else if (anti <= 0.125 && Dam > 0) {
			armbrk = 0.25;
			System.out.println("Armor Breaking!!");
		}
		else if (anti <= 0.25 && Dam > 0) {
			armbrk = 0.12;
			System.out.println("Armor Breaking!!");
		}
		else if (anti <= 0.5 && Dam > 0) {
			armbrk = 0.05;
			System.out.println("Armor Breaking!!");
		}
		else {
			armbrk = 0.0;
		}
		px.Arm -= px.ArmMax * armbrk;	
	}
}
