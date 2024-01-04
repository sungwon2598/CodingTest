package com.example.bj14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static int m;
    private static int n;
    private static int copyMap[][];
    private static int map[][];
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};
    private static boolean visited[][];

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        List<Point> zeroLocations = new ArrayList<>();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(input2[j]);
                if (a == 0) {
                    zeroLocations.add(new Point(j, i));
                }
                map[i][j] = a;
            }
        }

        int max = 0;
        // 조합을 통해 모든 경우의 수 확인
        for (int i = 0; i < zeroLocations.size(); i++) {
            for (int j = i + 1; j < zeroLocations.size(); j++) {
                for (int k = j + 1; k < zeroLocations.size(); k++) {
                    Point p1 = zeroLocations.get(i);
                    Point p2 = zeroLocations.get(j);
                    Point p3 = zeroLocations.get(k);

                    copyMap = deepCopyMap(map); // 깊은 복사 사용
                    visited = new boolean[n][m];
                    copyMap[p1.y][p1.x] = 1;
                    copyMap[p2.y][p2.x] = 1;
                    copyMap[p3.y][p3.x] = 1;

                    for (int l = 0; l < n; l++) {
                        for (int o = 0; o < m; o++) {
                            if (copyMap[l][o] == 2 && !visited[l][o]) {
                                bfs(l, o);
                            }
                        }
                    }
                    max = Math.max(max, calculateSafeArea(copyMap)); // 안전 영역 계산
                }
            }
        }
        System.out.println(max);
    }

    private static int[][] deepCopyMap(int[][] original) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, m);
        }
        return copy;
    }

    private static int calculateSafeArea(int[][] map) {
        int safeArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        visited[y][x] = true;
        queue.offer(new int[]{y, x});

        while (!queue.isEmpty()) {
            int location[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ax = location[1] + dx[i];
                int ay = location[0] + dy[i];

                if (ax >= 0 && ay >= 0 && ax < m && ay < n && copyMap[ay][ax] == 0 && !visited[ay][ax]) {
                    copyMap[ay][ax] = 2;
                    queue.offer(new int[]{ay, ax});
                    visited[ay][ax] = true;
                }
            }
        }
    }
}

