package com.example.pr전화번호목록;

import java.util.*;

public class SetByStartsWith { //시간초과
    public boolean solution(String[] phone_book) {

        HashSet<String> set = new HashSet<>();
        for(String num : phone_book) {
            set.add(num);
        }
        boolean answer = true;
        for(String phone : set) {
            for(String phone2 : set) {
                if(!phone.equals(phone2) && phone.startsWith(phone2)) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}