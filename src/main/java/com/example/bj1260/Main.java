package com.example.bj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static List<List<Integer>> list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        initVisited(n);
        dfs(v);
        System.out.println();

        initVisited(n);
        bfs(v, list, visited);
    }

    private static void initVisited(int n) {
        visited = new boolean[n + 1];
    }

    private static void dfs(int nodeIndex) {
        visited[nodeIndex] = true;

        System.out.print(nodeIndex+" ");

        for (int i = 0; i < list.get(nodeIndex).size(); i++) {
            int node = list.get(nodeIndex).get(i);
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    private static void bfs(int v, List<List<Integer>> list, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v+" ");
            for (int i = 0; i < list.get(v).size(); i++) {
                int index = list.get(v).get(i);
                if(!visited[index]) {
                    visited[index] = true;
                    queue.add(index);
                }
            }
        }
    }
}
