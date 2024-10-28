package com.example.pr주식가격;

import java.util.Stack;

public class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<>();
        for(int i = prices.length - 1; i >= 0; i--) {
            st.add(prices[i]);
        }
        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }
        int[] answer = {};
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(new int[]{1, 2, 5, 3, 6, 4});
    }
}
