import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class P10523 {
	public static void main(String[] args) throws FileNotFoundException {
      Scanner scan = new Scanner(System.in);
//		Scanner scan = new Scanner(new File("input.txt"));

		while (scan.hasNextInt()) {
			int N = scan.nextInt();
			BigInteger A = scan.nextBigInteger();

			BigInteger result = new BigInteger("0");
			BigInteger ONE = BigInteger.ONE;
			BigInteger j = new BigInteger("1");
			int  i = 1;
			for (i = 1, j = ONE; i <= N; i++, j = j.add(ONE)) {
				BigInteger val = A.pow(i);
				val = val.multiply(j);
				result = result.add(val);
			}

			System.out.println(result);
		}
	}
}
