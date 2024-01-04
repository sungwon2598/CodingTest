package com.example.bj5525다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0;
        int patternCount = 0;

        for (int i = 1; i < m - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                patternCount++; // 'IOI' 패턴 카운트
                if (patternCount == n) {
                    count++; // 완전한 패턴 발견
                    patternCount--; // 시작점 업데이트
                }
                i++; // 'O'를 건너뛰기
            } else {
                patternCount = 0; // 패턴 초기화
            }
        }

        System.out.println(count);
    }
}


