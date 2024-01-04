package com.example.bj14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int p = i;
            while (p < n) {
                dp[i] += arr[p][1];
                p += arr[p][0];
                System.out.println(p);
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n]);
    }
}
