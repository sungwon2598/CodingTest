package com.example.bj10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};
    private static boolean visited[][];
    private static String map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        for (int i = 0; i < n; i++) {
            String input[] = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j];
            }
        }

        int cnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("R") && !visited[i][j]) {
                    dfsR(i, j);
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("B") && !visited[i][j]) {
                    dfsB(i, j);
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("G") && !visited[i][j]) {
                    dfsG(i, j);
                    cnt++;
                }
            }
        }



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("G")) {
                    map[i][j] = "R";
                }
            }
        }
        System.out.print(cnt+" ");

        cnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("R") && !visited[i][j]) {
                    dfsR(i, j);
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("B") && !visited[i][j]) {
                    dfsB(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }

    private static void dfsG(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if (ax >= 0 && ay >= 0 && ax < n && ay < n && map[ay][ax].equals("G") && !visited[ay][ax]) {
                visited[ay][ax] = true;
                dfsG(ay, ax);
            }
        }
    }

    private static void dfsB(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if (ax >= 0 && ay >= 0 && ax < n && ay < n && map[ay][ax].equals("B") && !visited[ay][ax]) {
                visited[ay][ax] = true;
                dfsB(ay, ax);
            }
        }
    }

    private static void dfsR(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if (ax >= 0 && ay >= 0 && ax < n && ay < n && map[ay][ax].equals("R") && !visited[ay][ax]) {
                visited[ay][ax] = true;
                dfsR(ay, ax);
            }
        }
    }
}
