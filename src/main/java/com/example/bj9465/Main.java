package com.example.bj9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            int arr[][] = new int[3][size + 1];
            int dp[][] = new int[3][size + 1];

            String input[] = br.readLine().split(" ");
            for (int j = 1; j <= size; j++) {
                arr[1][j] = Integer.parseInt(input[j - 1]);
            }
            String input2[] = br.readLine().split(" ");
            for (int j = 1; j <= size; j++) {
                arr[2][j] = Integer.parseInt(input2[j - 1]);
            }

            if (size >= 1) {
                dp[1][1] = arr[1][1];
                dp[2][1] = arr[2][1];
            }
            if (size >= 2) {
                dp[1][2] = arr[1][2] + arr[2][1];
                dp[2][2] = arr[2][2] + arr[1][1];
            }
            if (size >= 3) {
                for (int k = 3; k <= size; k++) {
                    dp[1][k] = Math.max(dp[2][k - 1], dp[2][k - 2]) + arr[1][k];
                    dp[2][k] = Math.max(dp[1][k - 1], dp[1][k - 2]) + arr[2][k];
                }
            }

            System.out.println(Math.max(dp[1][size], dp[2][size]));
        }


    }
}
