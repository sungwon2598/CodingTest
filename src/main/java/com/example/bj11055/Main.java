package com.example.bj11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int maxDp = 0;
        int dp[] = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int max = 0;
            int index = arr[i] + 1;
            for (int j = i; j >= 0; j--) {
                if (index > arr[j]) {
                    if (max < dp[j]) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + arr[i];
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
