package com.example.bj12865다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int N = 1; N <= n; N++) {
            for (int K = 1; K <= k; K++) {
                dp[N][K] = dp[N - 1][K];
                if (K - w[N] >= 0) {
                    dp[N][K] = Math.max(dp[N - 1][K], dp[N - 1][K - w[N]] + v[N]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
