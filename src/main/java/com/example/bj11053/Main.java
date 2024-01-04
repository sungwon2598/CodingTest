package com.example.bj11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int p = arr[i];
            for (int j = i; j < n - 1; j++) {
                if (j == i) {
                    p = arr[i];
                } else if (p < arr[j + 1]) {
                    cnt++;
                    p = arr[j];
                }
            }
            if (max < cnt) {
                max = cnt;
            }
        }
        System.out.println(max);
    }
}
