package com.example.bj1071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(input[i]);
            if (arrayList.contains(a)) {
                int size = hashMap.get(a);
                hashMap.put(a, ++size);
            } else {
                arrayList.add(a);
                hashMap.put(a, 1);
            }
        }
        Collections.sort(arrayList);

        while (!arrayList.isEmpty()) {

        }

    }
}
