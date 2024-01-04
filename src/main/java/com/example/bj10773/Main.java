package com.example.bj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                stack.pop();
            } else {
                stack.push(a);
            }
        }

        int sum = 0;
        for (int o : stack) {
            sum += o;
        }

        System.out.println(sum);
    }
}
