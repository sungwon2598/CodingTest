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

class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int arr[][] = new int[n + 2][m + 3];
        for (int i = 2; i <= n + 1; i++) {
            String input2[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input2[0]);
            arr[i][1] = Integer.parseInt(input2[1]);
        }

        int k = 1;
        for (int i = 3; i <= m + 2; i++) {
            arr[0][i] = k;
            k++;
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[1].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[0][j + 2] - arr[i + 1][0] >= 0) {
                    int gap = arr[0][j + 2] - arr[i + 1][0];
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][gap] + arr[i + 1][1]);
                }
            }
        }

//        for (int i = 0; i < n + 1; i++) {
//            for (int j = 0; j < m + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
        System.out.println(dp[n][m]);


    }
}