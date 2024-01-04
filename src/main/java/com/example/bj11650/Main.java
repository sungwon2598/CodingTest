package com.example.bj11650;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i][0] > arr[j][0]) {
                    int tmp = arr[i][0];
                    arr[i][0] = arr[j][0];
                    arr[j][0] = tmp;
                } else if (arr[i][0] == arr[j][0]) {
                    if (arr[i][1] > arr[j][1]) {
                        int tmp = arr[i][1];
                        arr[i][1] = arr[j][1];
                        arr[j][1] = tmp;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
