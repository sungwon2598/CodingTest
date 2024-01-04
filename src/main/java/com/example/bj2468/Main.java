package com.example.bj2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int map[][];
    private static boolean visited[][];
    private static int copyMap[][];
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};
    private static int mapLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        mapLength = Integer.parseInt(br.readLine());
        map = new int[mapLength][mapLength];


        int inputMax = 0;
        for (int i = 0; i < mapLength; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < mapLength; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                inputMax = Math.max(inputMax, Integer.parseInt(input[j]));
            }
        }

        int max = 0;
        for (int p = 0; p < inputMax; p++) {
            copyMap = new int[mapLength][mapLength];
            visited = new boolean[mapLength][mapLength];
            for (int i = 0; i < mapLength; i++) {
                for (int j = 0; j < mapLength; j++) {
                    if (map[i][j] > p) {
                        copyMap[i][j] = 1;
                    } else {
                        copyMap[i][j] = 0;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < mapLength; i++) {
                for (int j = 0; j < mapLength; j++) {
                    if (copyMap[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int ax = x + dx[k];
            int ay = y + dy[k];

            if (ax >= 0 && ay >= 0 && ax < mapLength && ay < mapLength && copyMap[ay][ax] == 1 && !visited[ay][ax]) {
                visited[ay][ax] = true;
                dfs(ay, ax);
            }
        }
    }
}
