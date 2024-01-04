package com.example.bj12904다시보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer(br.readLine());
        StringBuffer t = new StringBuffer(br.readLine());

        while (t.length() > s.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }
        if (t.toString().equals(s.toString())) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}

class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String secondLine = br.readLine();

        StringBuilder second = new StringBuilder(secondLine);
        while (second.length() != first.length()) {
            if (second.charAt(second.length() - 1) == 'A') {
                second.deleteCharAt(second.length() - 1);
            } else {
                second.deleteCharAt(second.length() - 1);
                second.reverse();
            }
        }

        String result = new String(second);
        if(result.equals(first)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
