package com.example.bj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int node;
    static int line;
    static int cnt;
    static int[][] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine()); //노드 수
        line = Integer.parseInt(br.readLine()); //간선 수

        arr = new int[node + 1][node + 1]; //노드 연걀확인 배열
        check = new boolean[node + 1]; //감염여부
        cnt = 0; //총 감염수

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(cnt - 1);
    }

    public static void dfs(int k) {
        check[k] = true;
        cnt++;
        for (int i = 1; i <= node; i++) {
            if (arr[k][i] == 1 && !check[i]) { //인접노드가 감염X,연결O라면
                dfs(i); //인접노드dfs
            }
        }
    }

}
