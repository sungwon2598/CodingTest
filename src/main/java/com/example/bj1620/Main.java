package com.example.bj1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int qz = Integer.parseInt(input[1]);

        HashMap<String, Integer> list = new HashMap<>();
        HashMap<Integer, String> list2 = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String b = br.readLine();
            list.put(b, i + 1);
            list2.put(i + 1, b);
        }

        for (int i = 0; i < qz; i++) {
            String a = br.readLine();
            try {
                int index = Integer.parseInt(a);
                System.out.println(list2.get(index));
            } catch (NumberFormatException e) {
                System.out.println(list.get(a));
            }
        }
    }
}