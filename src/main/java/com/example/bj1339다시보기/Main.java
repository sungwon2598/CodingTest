package com.example.bj1339다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] abc = new int[26]; //알파벳 26개 배열
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            int ten = (int) Math.pow(10, arr[i].length() - 1);
            for (int j = 0; j < arr[i].length(); j++) {
                abc[(int) arr[i].charAt(j) - 65] += ten;
                ten /= 10;
            }
        }

        Arrays.sort(abc);
        int first = 9;
        int sum = 0;
        for (int i = abc.length - 1; i >= 0; i--) {
            if (abc[i] != 0) {
                sum += abc[i] * first;
                first--;
            }
        }
        System.out.println(sum);
    }
}
