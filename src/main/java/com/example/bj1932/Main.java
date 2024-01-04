package com.example.bj1932;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (dp[n - 1][i] < dp[n - 1][j]) {
                    int tmp = dp[n - 1][i];
                    dp[n - 1][i] = dp[n - 1][j];
                    dp[n - 1][j] = tmp;
                }
            }
        }
        System.out.println(dp[n - 1][0]);
    }
}
