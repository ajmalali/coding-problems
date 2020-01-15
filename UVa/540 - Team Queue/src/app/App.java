package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("tests.txt"));
        // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int scenario = 1;
        while (true) {
            int numTeams = Integer.parseInt(reader.readLine());

            if (numTeams == 0) {
                break;
            }

            // Maps element to team number
            Map<Integer, Integer> elementMap = new HashMap<>();
            for (int i = 0; i < numTeams; i++) {
                String[] elements = reader.readLine().split(" ");
                int totalElements = Integer.parseInt(elements[0]);

                for (int j = 1; j <= totalElements; j++) {
                    elementMap.put(Integer.parseInt(elements[j]), i);
                }
            }

            TeamQueue queue = new TeamQueue(elementMap);

            System.out.println("Scenario #" + scenario);
            while (true) {
                String[] command = reader.readLine().split(" ");

                if (command[0].equals("STOP")) {
                    scenario++;
                    System.out.println();
                    break;
                } else if (command[0].equals("ENQUEUE")) {
                    int el = Integer.parseInt(command[1]);
                    queue.enqueue(el);
                } else {
                    System.out.println(queue.dequeue());
                }
            }
        }

        reader.close();
    }
}

class TeamQueue {
    // Team queue (holds all team queues)
    private LinkedList<Queue<Integer>> queue;
    // Maps element to its team number
    private Map<Integer, Integer> elementMap;
    // Maps team number to its queue
    private Map<Integer, Queue<Integer>> teamMap;

    public TeamQueue(Map<Integer, Integer> map) {
        this.elementMap = map;
        this.queue = new LinkedList<>();
        this.teamMap = new HashMap<>();
    }

    public void enqueue(int el) {
        int teamNumber = this.elementMap.get(el);
        Queue<Integer> teamQueue = this.teamMap.get(teamNumber);
        if (teamQueue == null) {
            teamQueue = new LinkedList<>();
            teamQueue.add(el);
            teamMap.put(teamNumber, teamQueue);
            this.queue.add(teamQueue);
        } else {
            teamQueue.add(el);
        }
    }

    public int dequeue() {
        Queue<Integer> teamQueue = this.queue.peek();
        int element = -1;
        if (teamQueue != null) {
            element = teamQueue.poll();
            if (teamQueue.isEmpty()) {
                int teamNumber = this.elementMap.get(element);
                this.teamMap.remove(teamNumber);
                this.queue.removeFirst();
            }
        }

        return element;
    }
}