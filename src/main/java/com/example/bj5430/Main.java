package com.example.bj5430;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int n = Integer.parseInt(num);

        for (int i = 0; i < n; i++) {
            String order1 = br.readLine();
            String[] orderArr = order1.split("");

            String number = br.readLine();
            int number1 = Integer.parseInt(number);

            String arr = br.readLine();
            String[] numberStrings = arr.replaceAll("[\\[\\]]", "").split(",");
            List<String> list = new ArrayList<>(Arrays.asList(numberStrings));

            List<Integer> numList = new ArrayList<>();
            if (!list.get(0).equals("")) {
                for (int j = 0; j < list.size(); j++) {
                    numList.add(Integer.parseInt(list.get(j)));
                }
            }
            for (int j = 0; j < orderArr.length; j++) {
                String order = orderArr[j];
                if (order.equals("R")) {
                    Collections.reverse(numList);
                } else {
                    if (numList.size() == 0) {
                        System.out.println("error");
                    } else {
                        numList.remove(0);
                    }
                }
            }
            if (numList.size() != 0) {
                System.out.print("[");
                for (int j = 0; j < numList.size(); j++) {
                    if (j != 0) {
                        System.out.print(",");
                    }
                    System.out.print(numList.get(j));
                }
                System.out.println("]");
            }
        }
    }
}
