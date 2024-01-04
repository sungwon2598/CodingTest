package com.example.bj28278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            if (a == 1) {
                int b = Integer.parseInt(input[1]);
                stack.push(b);
            } else if (a == 2) {
                if (stack.empty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(stack.pop()).append('\n');
                }
            } else if (a == 3) {
                sb.append(stack.size()).append('\n');
            } else if (a == 4) {
                if (stack.empty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else {
                if (stack.empty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(stack.peek()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}

