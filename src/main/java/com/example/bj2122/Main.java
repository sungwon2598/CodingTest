package com.example.bj2122;

import java.util.Arrays;
import java.util.Scanner;

//bj2122
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[] cal = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            cal[i] = Math.abs(arr[i] - arr[i + 1]);
        }
        Arrays.sort(cal);
        int sum = 0;
        for (int i = 0; i < cal.length - (k - 1); i++) {
            sum += cal[i];
        }
        System.out.println(sum);
    }
}
