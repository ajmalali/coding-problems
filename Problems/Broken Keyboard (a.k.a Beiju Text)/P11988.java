import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

public class P11988 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			System.out.println(solver(scanner.nextLine()));
		}
		scanner.close();
	}
	
	private static String solver(String input) {
		List<Character> list = new LinkedList<>();
		
		int index = 0;
		char letter;
		for (int i = 0; i < input.length(); i++) {
			letter = input.charAt(i);
			if (letter == '[') {
				index = 0;
				continue;
			} else if (letter == ']') {
				index = list.size();
				continue;
			} 
			
			list.add(index, letter);
			index++;
		}
		
		StringBuilder builder = new StringBuilder();
		for(char c : list) {
			builder.append(c);
		}
		
		return builder.toString();
	}

}
