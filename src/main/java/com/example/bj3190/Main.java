package com.example.bj3190;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Main {
//    private static int n;
//    private static int d = 1;
//    private static int map[][];
//    //    0
//    // 3     1
//    //    2
//    private static int dx[] = {0, 1, 0, -1};
//    private static int dy[] = {-1, 0, 1, 0};
//    private static Queue<Node> queue = new LinkedList<Node>();
//    private static HashMap<Integer, String> turn = new HashMap<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        map = new int[n][n];
//
//        int k = Integer.parseInt(br.readLine());
//        for (int i = 0; i < k; i++) {
//            String input[] = br.readLine().split(" ");
//            int y = Integer.parseInt(input[0]) - 1;
//            int x = Integer.parseInt(input[1]) - 1;
//            map[x][y] = 1;
//        }
//
//        int l = Integer.parseInt(br.readLine());
//        for (int i = 0; i < l; i++) {
//            String input2[] = br.readLine().split(" ");
//            int a = Integer.parseInt(input2[0]);
//            String b = input2[1];
//            turn.put(a, b);
//        }
//
//        int time = 0;
//        int x = 0;
//        int y = 0;
//
//        Queue<Node> queue = new LinkedList<>();
//        while (true) {
//            x = x + dx[d];
//            y = y + dy[d];
//            if (gameOver(x, y)) {
//                break;
//            }
//            time++;
//            queue.offer(new Node(x, y));
//            queue.poll();
//
//            if (map[x][y] == 1) {
//                queue.offer(new Node(x, y));
//            }
//
//            if (turn.containsKey(time)) {
//                String direction = turn.get(time);
//                if (direction.equals("L")) {
//                    if (d == 0) {
//                        d = 3;
//                    } else {
//                        d = d - 1;
//                    }
//                } else {
//                    if (d == 3) {
//                        d = 1;
//                    } else {
//                        d = d + 1;
//                    }
//                }
//            }
//
//        }
//
//        System.out.println(time);
//
//    }
//
//
//    public static boolean gameOver(int x, int y) {
//        if (x > 0 || y > 0 || x >= n || y >= n) {
//            return true;
//        }
//        if (queue.contains()) {
//            return false;
//        }
//    }
//
//    private static class Node(int x, int y) {
//        int x;
//        int y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//}

