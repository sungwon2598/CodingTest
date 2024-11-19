package com.example.gale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        abc(new boolean[2 * n - 1], n - 1, n, 0); // 첫번째는 무조건 (
    }

    //a = (, b = )
    private static void abc(boolean arr[], int a, int b, int index) {
        if (a == 0 && b == 0) {
            printG(arr);
        }
        if (a != 0) {
            arr[index] = true;
            abc(arr, a - 1, b, index + 1);
            arr[index] = false;
        }
        if (b != 0 && b > a) {
            abc(arr, a, b - 1, index + 1);

        }
    }

    private static void printG(boolean arr[]) {
        System.out.print("(");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                System.out.print("(");
            } else {
                System.out.print(")");
            }
        }
        System.out.println();
    }
}
