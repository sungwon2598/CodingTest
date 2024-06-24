package com.example.pr완주하지못한선수;

import java.util.HashMap;
import java.util.HashSet;

public class Map {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        for(String comp : completion) {
            map.put(comp, map.get(comp) - 1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return null;
    }
}