import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P10226 {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scan = new Scanner(System.in);
		Scanner scan = new Scanner(new File("input.txt"));
		String tree;
		int tests = scan.nextInt();
		scan.nextLine();
		scan.nextLine();
		while (tests-- > 0) {
			TreeMap<String, Integer> map = new TreeMap<>();
			double totalTrees = 0;
			int freq = 0;

			while (scan.hasNextLine()) {
				tree = scan.nextLine();
				if (tree.isEmpty()) {
					break;
				}
				
				if (map.containsKey(tree)) {
					freq = map.get(tree);
					map.put(tree, freq + 1);
				} else {	
					map.put(tree, 1);
				}
				
				totalTrees++;
			}
			
			for (Map.Entry<String, Integer> i: map.entrySet()) {
				System.out.printf("%s %.4f\n", i.getKey(), (i.getValue()/totalTrees) * 100);
			}
			
			if (tests != 0) {
				System.out.println();
			}

		}
		
		scan.close();

	}

}