package com.example.bj11000;

import java.util.Arrays;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    static class Class implements Comparable<Class> {
        int start, end;

        Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class other) {
            if (this.end == other.end) {
                return this.start - other.start;
            }
            return this.end - other.end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Class[] classes = new Class[N];

        for (int i = 0; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            classes[i] = new Class(start, end);
        }

        Arrays.sort(classes);

        // 우선순위 큐를 사용하여 현재 사용중인 강의실 관리
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();

        for (Class c : classes) {
            // 현재 강의실 중에서 가장 먼저 끝나는 강의실과 비교
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= c.start) {
                roomEndTimes.poll();
            }
            roomEndTimes.add(c.end);
        }

        // 우선순위 큐의 크기가 필요한 강의실의 수
        System.out.println(roomEndTimes.size());
        scanner.close();
    }
}

