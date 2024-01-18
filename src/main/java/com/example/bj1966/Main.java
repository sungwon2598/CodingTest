package com.example.bj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input1[] = br.readLine().split(" ");
            int size = Integer.parseInt(input1[0]);
            int num = Integer.parseInt(input1[1]);

            String input2[] = br.readLine().split(" ");

            LinkedList<int[]> queue = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                queue.offer(new int[]{j, Integer.parseInt(input2[j]), 0});
            }
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int index = 1;
            while (!queue.isEmpty()) {
                boolean isMax = true;
                int pri[] = queue.remove();
                for (int k = 0; k < queue.size(); k++) {
                    int oth = queue.get(k)[1];
                    if (pri[1] < oth) {
                        queue.offer(pri);
                        isMax = false;
                        break;
                    }
                }
                if (isMax == true) {
                    hashMap.put(pri[0], index);
                    index++;
                }
            }

            System.out.println(hashMap.get(num));

        }
    }
}
