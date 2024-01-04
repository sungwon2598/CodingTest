package com.example.bj1764다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String a = br.readLine();
            if (hashSet.contains(a)) {
                cnt++;
                arrayList.add(a);
            }
        }
        Collections.sort(arrayList);
        System.out.println(cnt);
        for (String i : arrayList) {
            System.out.println(i);
        }
    }
}
