package com.example.bj1697re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[] visited;
    static int max = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a[] = br.readLine().split(" ");
        int n = Integer.parseInt(a[0]);
        int k = Integer.parseInt(a[1]);

        visited = new int[100001];
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int next = q.poll();

            if(next - 1 >= 0 && visited[next - 1] != -1) {
                visited[next * 2] = visited[next] + 1;
                q.add(next * 2);
            }
            if(next * 2 <= max && visited[next * 2] != -1) {
                visited[next * 2] = visited[next] + 1;
                q.add(next * 2);
            }

            if(next + 1 <= max && visited[next * 2] != -1) {
                visited[next * 2] = visited[next] + 1;
                q.add(next * 2);
            }
        }

    }
}