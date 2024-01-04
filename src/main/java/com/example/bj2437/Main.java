package com.example.bj2437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int weights[] = new int[n];
        String input[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(weights);

        for (int weights1 : weights) {
            System.out.print(weights1+" ");
        }
        System.out.println();

        int target = 1;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > target) {
                break;
            }
            System.out.print(target+" ");
            target += weights[i];
        }

        System.out.println("final : "+target);
    }
}
