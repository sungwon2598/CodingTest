package com.example.bj10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[][] a = new String[5][15];
        for (int i = 0; i < 5; i++) {
            String[] ar = br.readLine().split("");
            int max = ar.length;
            System.arraycopy(ar, 0, a[i], 0, max);
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (a[j][i] != null) {
                    System.out.print(a[j][i]);
                }
            }
        }


    }
}

