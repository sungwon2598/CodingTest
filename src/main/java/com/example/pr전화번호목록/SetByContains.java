package com.example.pr전화번호목록;

import java.util.HashSet;

public class SetByContains {
    public boolean solution(String[] phone_book) {

        HashSet<String> set = new HashSet<>();
        for(String num : phone_book) {
            set.add(num);
        }
        boolean answer = true;
        for(String phone : set) {
            for(int i = 0; i < phone.length(); i++) {
                if(set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}
