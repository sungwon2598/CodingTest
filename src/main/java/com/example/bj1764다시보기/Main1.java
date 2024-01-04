package com.example.bj1764다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            arrayList1.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            arrayList2.add(br.readLine());
        }

        int cnt = 0;
        for (String i : arrayList1) {
            for (String j : arrayList2) {
                if (j.equals(i)) {
                    cnt++;
                    arrayList3.add(j);
                }
            }
        }
        Collections.sort(arrayList3);
        System.out.println(cnt);
        for (String i : arrayList3) {
            System.out.println(i);
        }
    }
}
