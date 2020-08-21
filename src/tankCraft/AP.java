package tankCraft;

import java.util.Scanner;

public class AP {
	// px is the victim, py is the shooter.
	public static void daM(Player px, Player py) {
		int Dam = 0;
		Scanner input = new Scanner(System.in);
		py.APnum -= 1;
		
		System.out.print("Please input the shooting degree: ");
		double degree = input.nextDouble();
		String Deter = Calculate.calculateR(py, px, degree);
		
		if (Deter.equals("y")) {
			int x1 = px.position[0];
			int y1 = px.position[1];
			int x2 = py.position[0];
			int y2 = py.position[1];
			double dis = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
			dis = Math.pow(dis, 0.5);
			double rand = 100 * Math.random();
			double prob = 0;
			double a = 20.0/(70*70*70);
			prob = Math.pow((20 - dis) / a,1/3.0);
			prob = (prob + 30 - (Math.pow(px.Arm,2)/5.0*8.0));
			if (rand <= prob) {
				Dam = (int) (-1.2*dis + 100 - (px.Arm * px.Arm /5.0*6.0));
				Dam = Dam + (int)(24 * Math.random());
				System.out.println("Armor Pierced!!!");
			}
			else {
				Dam = (int) (10 - px.Arm);
				Dam = Dam + (int)(6 * Math.random() - 3);
				System.out.println("Bounced");
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
