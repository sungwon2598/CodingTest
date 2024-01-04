package com.example.bj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n;
    private static int m;
    private static int map[][];
    private static boolean visited[][];
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input2[] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        int min = 1000000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    int k = bfs();
                    if (k != -1) {
                        min = Math.min(min, k);
                    }
                    map[i][j] = 1;
                }
            }
        }
        if (min == 1000000) {
            System.out.println("-1");
        } else {
            System.out.println(min);
        }
    }

    private static int bfs() {
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];
            int distance = current[2];

            if (x == m - 1 && y == n - 1) {
                return distance;
            }
            for (int j = 0; j < 4; j++) {
                int ax = x + dx[j];
                int ay = y + dy[j];
                if (ax >= 0 && ay >= 0 && ax < m && ay < n && map[ay][ax] == 0 && !visited[ay][ax]) {
                    visited[ay][ax] = true;
                    queue.offer(new int[]{ay, ax, distance + 1});
                }
            }
        }
        return -1;
    }

}
