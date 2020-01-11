package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class App {
    public static void main(final String[] args) throws Exception {
        final BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));

        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            // # of courses
            final int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            // # of categories
            final int m = Integer.parseInt(st.nextToken());

            final Set<String> takenCourses = new HashSet<>();
            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < k; ++i) {
                takenCourses.add(st.nextToken());
            }

            boolean willGraduate = true;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(reader.readLine());
                int c = Integer.parseInt(st.nextToken());
                final int r = Integer.parseInt(st.nextToken());

                int taken = 0;
                while (c-- > 0) {
                    if (takenCourses.contains(st.nextToken())) {
                        taken++;
                    }
                }

                if (taken < r) {
                    willGraduate = false;
                }
            }

            System.out.println(willGraduate ? "yes" : "no");
        }

        reader.close();
    }
}