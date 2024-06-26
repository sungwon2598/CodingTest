package com.example.pr베스트앨범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TwoMap {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, PriorityQueue<int[]>> map = new HashMap<>(); //장르별 곡 인덱스와 재생횟수
        HashMap<String, Integer> cnt = new HashMap<>(); //장르별 누적재생횟수

        for (int i = 0; i < genres.length; i++) {
            map.putIfAbsent(genres[i], new PriorityQueue<>((a, b) -> b[0] - a[0]));
            map.get(genres[i]).add(new int[]{plays[i], i});
            cnt.put(genres[i], cnt.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Integer> answerList = new ArrayList<>();
        List<String> generLank = new ArrayList<>(map.keySet());
        generLank.sort((a, b) -> cnt.get(b) - cnt.get(a));

        for (String genre : generLank) {
            PriorityQueue<int[]> ints = map.get(genre);
            for(int i = 0; i < 2 && !ints.isEmpty(); i++) {
                answerList.add(ints.poll()[1]);
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
