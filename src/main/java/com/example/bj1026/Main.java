package com.example.bj1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        String[] arr = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
            a.add(Integer.parseInt(arr[j]));
        }
        String[] arr2 = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
            b.add(Integer.parseInt(arr2[j]));
        }

        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int an = a.get(i);
            int bn = b.get(i);
            sum += an * bn;
        }

        System.out.println(sum);
    }
}
