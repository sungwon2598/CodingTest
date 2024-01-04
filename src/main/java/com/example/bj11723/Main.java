package com.example.bj11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> arrayList = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                arrayList.add(x);
            } else if (a.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                arrayList.remove(x);
            } else if (a.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (arrayList.contains(x)) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if (a.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (arrayList.contains(x)) {
                    arrayList.remove(x);
                } else {
                    arrayList.add(x);
                }
            } else if (a.equals("all")) {
                arrayList.clear();
                for (int j = 1; j < 21; j++) {
                    arrayList.add(j);
                }
            } else {
                arrayList.clear();
            }
        }
        System.out.println(sb);
    }
}
