package com.example.bj2667_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Integer> cnt;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n + 2][n + 2]; //첨부터 x,y축을 널널하게 잡던가 아니면 밑에 조건문 추가
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
                    cnt.add(bfs(i,j));
                }
            }
        }

        Collections.sort(cnt);
        System.out.println(cnt.size());
        for (int i = 0; i < cnt.size(); i++) {
            System.out.println(cnt.get(i));
        }
    }

    private static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ax = location[0] + dx[i];
                int ay = location[1] + dy[i];

                if (map[ax][ay] == 1 && !visited[ax][ay]) {
                    queue.offer(new int[] {ax, ay});
                    visited[ax][ay] = true;
                    count++;
                }
            }
        }
        return count;
    }

}