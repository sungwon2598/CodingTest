package com.example.bj18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
//            String input[] = br.readLine().split(" ");
//            String a = input[0];
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if (a.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(queue.poll()).append('\n');
                }
            } else if (a.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (a.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append("1").append('\n');
                } else {
                    sb.append("0").append('\n');
                }
            } else if (a.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(queue.peek()).append('\n');
                }
            } else {

                if (queue.isEmpty()) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(((LinkedList<Integer>) queue).peekLast()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
