package org.hthu.exam.huwei;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int m = Integer.parseInt(line[0]);

        line = in.nextLine().split(" ");

        PriorityQueue<Integer> processors = new PriorityQueue<>();
        PriorityQueue<Integer> jobs = new PriorityQueue<>();
        for (String s : line) {
            jobs.add(Integer.parseInt(s));
        }

        while (!jobs.isEmpty()) {
            int job = jobs.poll();
            if (processors.size() == m) {
                int processor = processors.poll();
                processors.offer(processor + job);
            } else {
                processors.offer(job);
            }
        }

        int max = processors.poll();
        while (!processors.isEmpty()) {
            max = processors.poll();
        }

        System.out.println(max);
    }
}
