package com.example.smaple;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int n;
    private static int d = 1;
    private static int[][] map;
    // 방향 벡터: 상, 우, 하, 좌
    private static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int y = Integer.parseInt(input[0]) - 1;
            int x = Integer.parseInt(input[1]) - 1;
            map[y][x] = 1; // 사과 위치를 1로 표시
        }

        HashMap<Integer, String> turn = new HashMap<>();
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            String b = input2[1];
            turn.put(a, b);
        }

        int time = 0;
        int x = 0;
        int y = 0;
        map[y][x] = 2; // 뱀의 초기 위치를 2로 표시
        queue.offer(new Node(x, y));

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (true) {
            time++;
            x += dx[d];
            y += dy[d];

            if (gameOver(x, y)) {
                break;
            }

            if (!queue.contains(new Node(x, y))) {
                queue.offer(new Node(x, y));
                if (map[y][x] == 1) {
                    map[y][x] = 0; // 사과 먹음
                } else {
                    Node tail = queue.poll();
                    map[tail.y][tail.x] = 0; // 꼬리 제거
                }
                map[y][x] = 2; // 뱀 머리 이동
            } else {
                break; // 자신의 몸과 충돌
            }

            if (turn.containsKey(time)) {
                String direction = turn.get(time);
                if (direction.equals("L")) {
                    d = (d + 3) % 4;
                } else {
                    d = (d + 1) % 4;
                }
            }
        }

        System.out.println(time);
    }

    public static boolean gameOver(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Node node = (Node) obj;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }
}




