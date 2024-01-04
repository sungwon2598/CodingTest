package com.example.bj2667_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Integer> cnt;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n + 2][n + 2];
        visited = new boolean[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        cnt = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j, n);
                    cnt.add(count);
                }
            }
        }

        Collections.sort(cnt);
        System.out.println(cnt.size());
        for (int i = 0; i < cnt.size(); i++) {
            System.out.println(cnt.get(i));
        }
    }

    private static void dfs(int x, int y, int n) {
        visited[x][y] = true;
        count++;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int ax = x+dx[i];
            int ay = y+dy[i];

                if (!visited[ax][ay] && map[ax][ay] == 1) {
                    dfs(ax, ay, n);
                }
        }
    }
}
