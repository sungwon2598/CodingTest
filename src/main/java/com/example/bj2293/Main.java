package com.example.bj2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        int coin[] = new int[n];
        Arrays.sort(coin);
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int dp[][] = new int[n + 1][p + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p + 1; j++) {
                if (j - coin[i] >= 0) {
                    dp[i + 1][j] = dp[i][j] + dp[i + 1][j - coin[i]];
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        System.out.println(dp[n][p]);
    }
}
