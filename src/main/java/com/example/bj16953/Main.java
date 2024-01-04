package com.example.bj16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int result = -1;
        int cnt = 1;
        while (a < b) {
            int end = b % 10;
            if (end == 3 || end == 5 || end == 7 || end == 9) {
                result = -1;
                break;
            }
            if (end == 1) {
                b = b / 10;
                cnt++;
            } else {
                b = b / 2;
                cnt++;
            }
        }

        if (a == b) {
            result = cnt;
        }

        System.out.println(result);
        
    }
}
