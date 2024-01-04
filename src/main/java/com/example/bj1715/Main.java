package com.example.bj1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        int size = queue.size();

        int sum = 0;
        for (int i = 0; i < size - 1; i++) {
            if (queue.size() == 1) {
                sum += queue.poll();
            } else {
                int first = queue.poll();
                int second = queue.poll();
                int hap = first + second;
                sum += hap;
                queue.add(hap);
            }
        }

        if (size == 1) {
            System.out.println(0);
        } else {
            System.out.println(sum);
        }
    }
}
