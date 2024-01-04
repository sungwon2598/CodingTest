package com.example.bj24444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static HashMap<Integer, Integer> index;
    private static int order = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 [] = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int v = Integer.parseInt(input1[2]);

        boolean[] visited = new boolean[n + 1];
        LinkedList<Integer>[] list = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            String input2[] = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i], Collections.reverseOrder());
        }

        index = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            index.put(i,0);
        }
        bfs(v, list, visited);

        for (int i = 1; i <= n; i++) {
            System.out.println(index.get(i));
        }
    }

    private static void bfs(int v, LinkedList<Integer>[] arr, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();

            index.put(v, order);
            order++;

            Iterator<Integer> iterator = arr[v].listIterator();
            while(iterator.hasNext()) {
                int w = iterator.next();
                if(!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }

        }
    }
}
