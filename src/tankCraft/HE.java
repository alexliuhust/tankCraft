package tankCraft;

import java.util.Scanner;

public class HE {
	// px is the victim, py is the shooter.
	public static void daM(Player px, Player py) {
		int Dam = 0;
		Scanner input = new Scanner(System.in);
		py.HEnum -= 1;
		
		System.out.print("Please input the shooting degree: ");
		double degree = input.nextDouble();
		String Deter = Calculate.calculateR(py, px, degree);
		
		if (Deter.equals("y")) {
			double rand = 100 * Math.random();
			double prob = 0;
			prob = 15 - px.Arm*px.Arm/2.0;
			if (rand <= prob) {
				Dam = 300;
				Dam = Dam + (int)(150 * Math.random() - 75);
				System.out.println("Boooooom!!");
			}
			else {
				Dam = (int) (75 - px.Arm * px.Arm / 2);
				Dam = Dam + (int)(30 * Math.random() - 15);
				System.out.println("Hit");
			}
			px.HP -= Dam;
			px.Dtaken = Dam;
			py.Dcuase = Dam;
			System.out.println("Damage: " + Dam);
		}
		else {
			System.out.println("MISS");
			
		}
	}
}
