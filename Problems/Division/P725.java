import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class P725 {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scan = new Scanner(System.in);
		Scanner scan = new Scanner(new File("input.txt"));
		boolean firstAnswer = true;
		while (scan.hasNextInt()) {
			int N = scan.nextInt();

			if (N == 0) {
				break;
			}
			
			if(!firstAnswer) {
				System.out.println();
			} else {
				firstAnswer = false;
			}

			int start = 1234, end = 98765, num = 0;
			boolean hasSolution = false;
			
			for (int den = start; den <= end; den++) {
				num = N * den;
				
				if (num > 98765) {
					break;
				}
				
				
				if (!allDifferent(den, num)) {
					continue;
				}
				
				hasSolution = true;
				System.out.printf("%05d / %05d = %d\n", num, den, N);
			}
			
			if (!hasSolution) {
				System.out.println("There are no solutions for " + N + ".");
			}
		}
		
		scan.close();
	}
	
	/*
	 * IDEA: Put the digits of the numerator and denominator in a HashSet.
	 * At the end, check if the size of the HashSet is 10.
	 * set.add(value) returns true if the digit is not present 
	 * in the set, and false if it is already present. 
	 */
	private static boolean allDifferent(int a, int b) {
		HashSet<Integer> set = new HashSet<>();
		
		int digit, count = 0;
		while (a != 0) {
			count++;
			digit = a % 10;
			if (!set.add(digit)) {
				return false;
			}
			a = a / 10;
		}
		
		if (count == 4) {
			set.add(0);
		}
		
		count = 0;
		while (b != 0) {
			count++;
			digit = b % 10;
			if (!set.add(digit)) {
				return false;
			}
			b = b / 10;
		}
		
		if (count == 4) {
			set.add(0);
		}

		return set.size() == 10;
	}

}
