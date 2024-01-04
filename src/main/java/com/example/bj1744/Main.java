package com.example.bj1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> min = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 1) {
                sum += 1;
            } else if (a > 1) {
                plus.add(a);
            } else {
                min.add(a);
            }
        }

        Collections.sort(min);
        int i = 0;
        while (i < min.size()) {
            if (i + 1 < min.size()) {
                sum += min.get(i) * min.get(i + 1);
                i += 2;
            } else {
                sum += min.get(i);
                i++;
            }
        }

        Collections.sort(plus, Collections.reverseOrder());
        int j = 0;
        while (j < plus.size()) {
            if (j + 1 < plus.size()) {
                sum += plus.get(j) * plus.get(j + 1);
                j += 2;
            } else {
                sum += plus.get(j);
                j++;
            }
        }
        System.out.println(sum);
    }
}

class Main2 {
    private static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                plus.add(num);
            } else if (num == 1) {
                sum += 1;
            } else {
                minus.add(num);
            }
        }

        sumAll(plus);
        sumAll(minus);

        System.out.println(sum);
    }

    public static void sumAll(PriorityQueue<Integer> priorityQueue) {
        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.size() >= 2) {
                sum += priorityQueue.poll() * priorityQueue.poll();
            } else if (priorityQueue.size() == 1) {
                sum += priorityQueue.poll();
            }
        }
    }
}
