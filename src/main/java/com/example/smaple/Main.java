package com.example.smaple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n; // 높이
    private static int m; // 너비

    private static int x; // 로봇청소기 x좌표
    private static int y; // 로봇청소기 y좌표
    private static int d; // 방향
    private static int map[][]; // 0:청소되지 않은 빈칸  1:벽  2:청소된 빈칸
    private static boolean turnOn = true;

    private static int clean = 0; // 청소한 칸 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1[] = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]); // 높이
        m = Integer.parseInt(input1[1]); // 너비

        String input2[] = br.readLine().split(" ");
        x = Integer.parseInt(input2[0]); // 로봇청소기 초기 좌표
        y = Integer.parseInt(input2[1]);
        d = Integer.parseInt(input2[2]); // 방향

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input3[] = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input3[j]);
            }
        }

        while (turnOn) {
            if (map[x][y] == 0) {
                claenHere();
            }

            if (isExistNotClean()) {
                backward();
            } else {
                turnLeft();
                if (isNotCleanAndNotWallFront()) {
                    forward();
                }
            }
        }

        System.out.println(clean);
    }

    private static void claenHere() {
        map[x][y] = 2;
        clean++;
    }

    private static void forward() {
        if (d == 0 && x > 0) {
            x--;
        } else if (d == 1 && y < m - 1) {
            y++;
        } else if (d == 2 && x < n - 1) {
            x++;
        } else if (d == 3 && y > 0) {
            y--;
        }
    }

    private static void backward() {
        if (d == 0 && x < n - 1) {
            x++;
        } else if (d == 1 && y > 0) {
            y--;
        } else if (d == 2 && x > 0) {
            x--;
        } else if (d == 3 && y < m - 1) {
            y++;
        }
        if (map[x][y] == 1) {
            turnOn = false;
        }
    }

    private static void turnLeft() {
        d = (d + 3) % 4;
    }

    private static boolean isExistNotClean() {
        boolean allCleanedOrWalled = true;
        if (x > 0) {
            allCleanedOrWalled &= (map[x - 1][y] != 0);
        }
        if (y > 0) {
            allCleanedOrWalled &= (map[x][y - 1] != 0);
        }
        if (x < n - 1) {
            allCleanedOrWalled &= (map[x + 1][y] != 0);
        }
        if (y < m - 1) {
            allCleanedOrWalled &= (map[x][y + 1] != 0);
        }
        return allCleanedOrWalled;
    }

    private static boolean isNotCleanAndNotWallFront() {
        if (d == 0 && x > 0) {
            return map[x - 1][y] == 0;
        } else if (d == 1 && y < m - 1) {
            return map[x][y + 1] == 0;
        } else if (d == 2 && x < n - 1) {
            return map[x + 1][y] == 0;
        } else if (d == 3 && y > 0) {
            return map[x][y - 1] == 0;
        }
        return false;
    }
}



