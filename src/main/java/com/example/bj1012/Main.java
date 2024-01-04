package com.example.bj1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int m;
    private static int n;
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, 1, -1};
    private static int cnt;
    private static int map[][];
    private static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String input[] = br.readLine().split(" ");
            m = Integer.parseInt(input[0]); //가로길이
            n = Integer.parseInt(input[1]); //세로길이
            int k = Integer.parseInt(input[2]); //배추갯수

            cnt = 0;
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int j = 0; j < k; j++) { //배추 위치지정
                String input2[] = br.readLine().split(" ");
                int x = Integer.parseInt(input2[0]);
                int y = Integer.parseInt(input2[1]);
                map[y][x] = 1;
            }
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (map[j][l] == 1 && !visited[j][l]) {
                        dfs(j, l);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ax = x + dx[i];
            int ay = y + dy[i];

            if (ax >= 0 && ay >= 0 && ax < m && ay < n && map[ay][ax] == 1 && !visited[ay][ax]) {
                dfs(ay, ax);
            }
        }
    }
}
