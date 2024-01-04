package com.example.bj1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] jewels = new int[n][2];
        Integer[] bags = new Integer[k];

        // 보석 정보 입력 받기
        for (int i = 0; i < n; i++) {
            String[] jewelInfo = br.readLine().split(" ");
            jewels[i][0] = Integer.parseInt(jewelInfo[0]); // 무게
            jewels[i][1] = Integer.parseInt(jewelInfo[1]); // 가치
        }

        // 가방 정보 입력 받기
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 보석을 무게 기준으로 정렬
        Arrays.sort(jewels, (a, b) -> a[0] - b[0]);
        // 가방을 무게 기준으로 정렬
        Arrays.sort(bags);

        // 우선순위 큐 (최대 힙) 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long totalValue = 0;
        int jewelIndex = 0;

        for (int i = 0; i < k; i++) {
            while (jewelIndex < n && jewels[jewelIndex][0] <= bags[i]) {
                pq.add(jewels[jewelIndex][1]);
                jewelIndex++;
            }

            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }

        System.out.println(totalValue);
    }
}

