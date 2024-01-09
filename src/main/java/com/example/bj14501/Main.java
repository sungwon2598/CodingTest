package com.example.bj14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[2][n + 1];
        for (int i = 1; i <= n; i++) {
            String input[] = br.readLine().split(" ");
            arr[0][i] = Integer.parseInt(input[0]); // 기간
            arr[1][i] = Integer.parseInt(input[1]); // 보수
        }

        int dp[] = new int[n + 2];
        for (int i = n; i >= 1; i--) {
            if (n + 1 - i >= arr[0][i]) {
                dp[i] = Math.max(arr[1][i] + dp[i + arr[0][i]], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[1]);
    }
}
