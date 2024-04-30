package com.example.bj14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    private static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String input[] = br.readLine().split("");
            lists.add(new ArrayList<Integer>());
            for (int j = 0; j < 8; j++) {
                lists.get(i).add(Integer.parseInt(input[j]));
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input2[] = br.readLine().split(" ");
            int k = Integer.parseInt(input2[0]);
            int r = Integer.parseInt(input2[1]);

            gear(k, r);

        }
        calculate();

        System.out.println(score);

    }

    private static void gear(int gearNum, int rotate) {

        int willRotate[] = new int[4];
        willRotate[gearNum - 1] = rotate;

        // 기준점 왼쪽 확인
        for (int i = gearNum - 1; i > 0; i--) {
            if (lists.get(i).get(6) != lists.get(i - 1).get(2) && willRotate[i] != 0) {
                if (willRotate[i] == 1) {
                    willRotate[i - 1] = -1;
                } else {
                    willRotate[i - 1] = 1;
                }
            }
        }

        // 기준점 오른쪽 확인
        for (int i = gearNum - 1; i < 3; i++) {
            if (lists.get(i).get(2) != lists.get(i + 1).get(6) && willRotate[i] != 0) {
                if (willRotate[i] == 1) {
                    willRotate[i + 1] = -1;
                } else {
                    willRotate[i + 1] = 1;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (willRotate[i] == 1) {
                rotateRight(i + 1);
            } else if(willRotate[i] == -1){
                rotateLeft(i + 1);
            }
        }
    }

    private static void calculate() {
        if (lists.get(0).get(0) == 1) {
            score += 1;
        }
        if (lists.get(1).get(0) == 1) {
            score += 2;
        }
        if (lists.get(2).get(0) == 1) {
            score += 4;
        }
        if (lists.get(3).get(0) == 1) {
            score += 8;
        }
    }


    private static void rotateRight(int k) {
        lists.get(k - 1).add(0, lists.get(k - 1).get(7));
        lists.get(k - 1).remove(8);
    }

    private static void rotateLeft(int k) {
        int temp = lists.get(k - 1).remove(0);
        lists.get(k - 1).add(temp);
    }

}
