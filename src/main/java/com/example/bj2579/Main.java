package com.example.bj2579;

import java.util.Scanner;

public class Main {
    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = arr[1];
        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        System.out.println(dpn(n));
    }

    static int dpn(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(dpn(n - 2), dpn(n - 3) + arr[n - 1]) + arr[n];
        }
        return dp[n];
    }
}
