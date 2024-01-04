package com.example.bj2293다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        for (int q = 0; q < n1; q++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int k = Integer.parseInt(br.readLine());
            int[] dp = new int[k + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = arr[i]; j <= k; j++) {
                    dp[j] += dp[j - arr[i]];
                }
            }
            System.out.println(dp[k]);
        }
    }
}

