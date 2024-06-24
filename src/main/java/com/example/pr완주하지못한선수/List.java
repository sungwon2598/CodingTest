package com.example.pr완주하지못한선수;

import java.util.*;

public class List { // 테스트 모두 통과, 시간초과
    public String solution(String[] participant, String[] completion) {
        ArrayList<String> participantList = new ArrayList<>();
        for(String part : participant) {
            participantList.add(part);
        }
        for(String comp : completion) {
            participantList.remove(comp);
        }

        String answer = participantList.get(0);
        return answer;
    }
}