package com.example.bj11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int parent[];
    private static boolean visited[];
    private static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

//        for (int i = 1; i < tree.size(); i++) {
//            for (int j = 0; j < tree.get(i).size(); j++) {
//                System.out.print(i + " " + tree.get(i).get(j) + " ");
//            }
//            System.out.println();
        dfs(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i = 0; i < tree.get(node).size(); i++) {
            if (!visited[tree.get(node).get(i)]) {
                parent[tree.get(node).get(i)] = node;
                dfs(tree.get(node).get(i));
            }
        }
    }
}
