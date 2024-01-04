package com.example.bj28279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            if (a == 1) {
                deque.addFirst(Integer.parseInt(input[1]));
            } else if (a == 2) {
                deque.addLast(Integer.parseInt(input[1]));
            } else if (a == 3) {
                if (deque.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(deque.removeFirst()).append('\n');
                }
            } else if (a == 4) {
                if (deque.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(deque.removeLast()).append('\n');
                }
            } else if (a == 5) {
                sb.append(deque.size()).append('\n');
            } else if (a == 6) {
                if (deque.isEmpty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if (a == 7) {
                if (deque.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(deque.getFirst()).append('\n');
                }
            } else {
                if (deque.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(deque.getLast()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
