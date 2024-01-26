package com.example.bj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int x;
    private static int y;
    private static int map[][];
    private static boolean visited[][];
    private static int dx[] = {-1, 0, 1, 0};
    private static int dy[] = {0, 1, 0, -1};
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1[] = br.readLine().split(" ");
        y = Integer.parseInt(input1[0]);
        x = Integer.parseInt(input1[1]);

        map = new int[y][x];
        visited = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            String input2[] = br.readLine().split("");
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(input2[j]);
            }
        }

        bfs();
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == x - 1 && node.y == y - 1) {
                System.out.println(cnt);
            }

            for (int i = 0; i < 4; i++) {
                int ax = node.x + dx[i];
                int ay = node.y + dy[i];

                if (ax >= 0 && ax < x && ay >= 0 && ay < y && visited[ay][ax] != true && map[ay][ax] != 0) {

                    visited[ay][ax] = true;
                    queue.add(new Node(ax, ay));
                    cnt++;
                }
            }
        }

    }

    private static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
