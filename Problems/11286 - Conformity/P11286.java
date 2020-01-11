import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.*;

public class P11286 {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner scan = new Scanner(System.in);
		Scanner scan = new Scanner(new File("../input.txt"));

      while (scan.hasNextInt()) {
         int n = scan.nextInt();
         if (n == 0) {
            break;
         }

         HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();

         while (n-- > 0) {
            ArrayList<Integer> courses = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
               courses.add(scan.nextInt());
            }

            Collections.sort(courses);
            if (map.containsKey(courses)) {
               map.put(courses, map.get(courses) + 1);
            } else {
               map.put(courses, 1);
            }
         }

         int maxCount = 0, max = -1, freq = 0;
         for (Map.Entry<ArrayList<Integer>, Integer> entry : map.entrySet()) {
            freq = entry.getValue();
            if (freq > max) {
               max = freq;
               maxCount = 1;
            } else if (freq == max) {
               maxCount++;
            }
         }

         System.out.println(max * maxCount);

      }
	}
}
