package com.example.bj24480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static List<List<Integer>> adj; // 이중 ArrayList로 인접 리스트 구현
    private static boolean[] visited;
    private static HashMap<Integer, Integer> index;
    private static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int r = Integer.parseInt(first[2]);

        visited = new boolean[n + 1];

        index = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            index.put(i, 0);
        }

        // 인접 리스트 초기화
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] second = br.readLine().split(" ");
            int a = Integer.parseInt(second[0]);
            int b = Integer.parseInt(second[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // 인접 리스트 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(adj.get(i), Collections.reverseOrder());
        }

        // DFS 실행
        dfs(r);

        // 방문 순서 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(index.get(i));
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        index.put(node, order++); // order를 증가시키면서 할당

        for (int i = 0; i < adj.get(node).size(); i++) {
            int linkedNode = adj.get(node).get(i);
            if (!visited[linkedNode]) {
                dfs(linkedNode);
            }
        }

    }

}

