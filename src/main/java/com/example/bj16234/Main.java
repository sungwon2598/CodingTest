package com.example.bj16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int l;
    private static int r;
    private static int map[][];
    private static boolean visited[][];
    private static boolean game;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1[] = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        l = Integer.parseInt(input1[1]);
        r = Integer.parseInt(input1[2]);

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input2[] = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        while (game) {
            game = false;

        }

    }
}
