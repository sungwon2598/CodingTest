package com.example.bj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static int x;
    private static int y;
    private static int cnt = -1;
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        map = new int[y][x];
        for (int i = 0; i < y; i++) {
            String input2[] = br.readLine().split(" ");
            for (int j = 0; j < x; j++) {
                int a = Integer.parseInt(input2[j]);
                map[i][j] = a;
                if (a == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] location = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int ax = location[1] + dx[j];
                    int ay = location[0] + dy[j];

                    if (ax >= 0 && ay >= 0 && ax < x && ay < y && map[ay][ax] == 0) {
                        map[ay][ax] = 1;
                        queue.add(new int[]{ay, ax});
                    }
                }
            }
            cnt++;
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(cnt);
    }
}
