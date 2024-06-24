package com.example.Pr포켓몬;
import java.util.*;

public class Set {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int numsLength = nums.length;
        for(int i = 0; i < numsLength; i++) {
            set.add(nums[i]);
        }
        int answer = 0;
        int setSize = set.size();
        if(setSize < numsLength / 2) {
            answer = setSize;
        } else {
            answer = numsLength / 2;
        }
        return answer;
    }
}
