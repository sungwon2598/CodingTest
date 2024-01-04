package com.example.bj1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 65; i <= 90; i++) {
            count.put((char) i, 0);
        }

        List<String> words = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(word);
        }

        for (int i = 0; i < words.size(); i++) {
            String string = words.get(i);
            int size = string.length();
            for (int j = 0; j < size; j++) {
                char key = (char) string.charAt(j);
                count.put(key, count.get(key) + (int) Math.pow(10, size - 1 - j));
            }
        }

        for (int i = 65; i <= 90; i++) {
            if (count.get((char) i) == 0) {
                count.remove((char) i);
            }
        }

        // Entry 리스트로 변환
        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(count.entrySet());

        // 값(value)을 기준으로 리스트 내림차순 정렬
        entries.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        // 정렬된 엔트리의 키만 추출하여 새로운 리스트 생성
        List<Character> sortedKeys = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : entries) {
            sortedKeys.add(entry.getKey());
        }

        int num = 9;
        for (int i = 0; i < sortedKeys.size(); i++) {
            count.put(sortedKeys.get(i), num);
            num--;
        }

        int sum = 0;
        for (int i = 0; i < words.size(); i++) {
            String string = words.get(i);
            int size = string.length();
            for (int j = 0; j < size; j++) {
                char a = string.charAt(j);
                int nume = count.get(a) * (int) Math.pow(10, size - 1 - j);
                sum += nume;
            }
        }

        System.out.println(sum);
    }
}

class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ch = 'A';
        Integer abc[] = new Integer[26];
        Arrays.fill(abc, 0);
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                int num = input[j];
                abc[num - ch] += (int) Math.pow(10, input.length - j - 1);
            }
        }

        List<Integer> list = Arrays.asList(abc);
        Collections.sort(list, Collections.reverseOrder());

        int sum = 0;
        int num = 9;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                break;
            }
            sum += list.get(i) * num--;
        }

        System.out.println(sum);
    }
}
