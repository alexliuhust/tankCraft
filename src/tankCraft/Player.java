package tankCraft;

import java.util.Scanner;

public class Player {
	
	Scanner input = new Scanner(System.in);
	String name;
	int HP;
	int HPMAX;
	double Arm;
	double ArmMax;
	int APnum;
	int ATnum;
	int HEnum;
	int Dcuase;
	int Dtaken;
	int position[] = new int[2];
	double speed;
	double speedMax;
	double size = 1.5;
	
	public void setInfo() {
		System.out.print("The hit points:");
		HP = input.nextInt();
		HPMAX = HP;
		System.out.print("The armor level:");
		Arm = input.nextInt();
		if (Arm > 7) Arm = 7.0;
		if (Arm < 0) Arm = 0.0;
		ArmMax = Arm;
		System.out.print("The speed:");
		speed = input.nextInt();
		speedMax = speed;
		System.out.println("The position:");
		position[0] = input.nextInt();
		position[1] = input.nextInt();
		System.out.print("The number of AP:");
		APnum = input.nextInt();
		System.out.print("The number of AT:");
		ATnum = input.nextInt();
		System.out.print("The number of HE:");
		HEnum = input.nextInt();
	}
	
	public void printInfo() {
		System.out.print("|");
		for (int i = 1; i <= (HP*20 / HPMAX); i++) {
			System.out.print("*");
		}
		for (int i = (HP*20 / HPMAX) + 1; i <= 20; i++) {
			System.out.print(" ");
		}
		Arm = (int)(Arm * 100) / 100.0;
		System.out.print("|  ");
		System.out.println("HP: " + HP + "/" + HPMAX + "\t\tArm: " + Arm + "\tSpeed: " + speed);
		System.out.println("Position: (" + position[0] + ", " + position[1] + ")");
		System.out.println("AP: " + APnum + "\t\tAT: " + ATnum + "\t\tHE: " + HEnum);
		System.out.println("--------------------------------------------------------");
	}
	
	public void move() {
		System.out.println("MOVE!!!");
		System.out.print("Input the degree and the distance: ");
		double degree = input.nextDouble();
		double theta = Math.toRadians(degree);
		double distance = input.nextDouble();
		if (distance <= speed) {
			position[0] += Math.round(distance * Math.cos(theta));
			position[1] += Math.round(distance * Math.sin(theta));
		}
		else {
			position[0] += Math.round(speed * Math.cos(theta));
			position[1] += Math.round(speed * Math.sin(theta));
		}
		System.out.println("Current position: (" + position[0] + ", " + position[1] + ")");
		
		
	}
	
	
	
	
	
	
	
	
	
}
