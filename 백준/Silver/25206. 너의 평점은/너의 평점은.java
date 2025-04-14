import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double total = 0;
		double creditTotal = 0;
		for (int i = 0; i < 20; i++) {
			String str = br.readLine();
			double credit = Double.parseDouble(str.split(" ")[1]);
			String grade = str.split(" ")[2];
			if (!grade.equals("P")) creditTotal += credit;
			
			switch (grade) {
			case "A+":
				total += (4.5 * credit);
				break;
			case "A0":
				total += (4.0 * credit);
				break;
			case "B+":
				total += (3.5 * credit);
				break;
			case "B0":
				total += (3.0 * credit);
				break;
			case "C+":
				total += (2.5 * credit);
				break;
			case "C0":
				total += (2.0 * credit);
				break;
			case "D+":
				total += (1.5 * credit);
				break;
			case "D0":
				total += (1.0 * credit);
				break;
			case "F":
				total += (0.0 * credit);
				break;
			default:
				break;
			}
		
		}
		System.out.printf("%.6f", total / creditTotal);
	}

}
