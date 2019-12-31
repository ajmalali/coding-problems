import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P11507 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scan = new Scanner(System.in);
		Scanner scan = new Scanner(new File("input.txt"));

		while(scan.hasNextLine()) {
			int L = scan.nextInt();
			if (L == 0) {
				break;
			}

			scan.nextLine();
			String[] instructions = scan.nextLine().split(" ");
//			StringBuilder builder = new StringBuilder();

			String head = "+x";
			for(String inst: instructions) {
				if (inst.equals("No")) {
					continue;
				}

				switch (head) {
				case "+x":
					head = inst;
					break;

				case "-x":
					switch (inst) {
					case "+y":
						head = "-y";
						break;
					case "-y":
						head = "+y";
						break;
					case "+z":
						head = "-z";
						break;
					case "-z":
						head = "+z";
						break;
					}
					break;

				case "+y":
					if (inst.equals("+y")) {
						head = "-x";
					} else if (inst.equals("-y")) {
						head = "+x";
					}
					break;

				case "-y":
					switch (inst) {
					case "+y":
						head = "+x";
						break;
					case "-y":
						head = "-x";
						break;
					}
					break;

				case "+z":
					if (inst.equals("+z")) {
						head = "-x";
					} else if (inst.equals("-z")) {
						head = "+x";
					}

					break;

				case "-z":
					switch (inst) {
					case "+z":
						head = "+x";
						break;
					case "-z":
						head = "-x";
						break;
					}
					break;

				}
			}

			System.out.println(head);

		}

		scan.close();

	}



}
