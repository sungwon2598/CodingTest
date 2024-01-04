package com.example.bj1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> min = new ArrayList<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st2.nextToken());
            if (a > 0) {
                plus.add(a);
            } else {
                min.add(Math.abs(a));
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(min, Collections.reverseOrder());

        int max = 0;
        if (plus.size() != 0 && min.size() != 0) {
            max = Math.max(plus.get(0), min.get(0));
        } else if (plus.size() == 0) {
            max = min.get(0);
        } else {
            max = plus.get(0);
        }

        int sum = 0;//총 이동거리 변수선언
        sum += max;
        int plussize = plus.size();
        int minsize = min.size();
        if (plus.size() != 0 && max == plus.get(0)) {
            int i = 0;
            while (i < m && i < plussize) {
                plus.remove(0);
                i++;
            }
        } else {
            int i = 0;
            while (i < m && i < minsize) {
                min.remove(0);
                i++;
            }
        }
        int i = 0;
        while (i < min.size()) {
            sum += min.get(i) * 2;
            i += m;
        }
        int j = 0;
        while ((j < plus.size())) {
            sum += plus.get(j) * 2;
            j += m;
        }
        System.out.println(sum);
    }
}
