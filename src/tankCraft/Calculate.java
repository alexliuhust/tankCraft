package tankCraft;

public class Calculate {

	private static void getLinePara(double linepara[],Player p1,double degree) {
		if (degree != 90.0) {
			double theta = Math.toRadians(degree);
			linepara[0] = Math.tan(theta);
			linepara[1] = -1.0;
			linepara[2] = p1.position[1] - Math.tan(theta) * p1.position[0];
		}
		else {
			linepara[0] = 1.0;
			linepara[1] = 0.0;
			linepara[2] = -p1.position[0];
		}
		
	}
	
	public static String calculateR(Player p1, Player p2, double degree) {
		double linepara[] = new double[3]; 
		double upper;
		double lower;
		getLinePara(linepara, p1, degree);
		double x = p2.position[0];
		double y = p2.position[1];
		double A = linepara[0];
		double B = linepara[1];
		double C = linepara[2];
		upper = Math.abs(A*x + B*y + C);
		lower = Math.pow(A*A+B*B,0.5);
		double disR =(double)upper/lower;
		if (disR <= p2.size) return "y";
		else return "n";
	}
}
