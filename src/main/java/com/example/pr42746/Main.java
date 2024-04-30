package com.example.pr42746;

import java.util.Arrays;

public class Main {
    public static Solution solution = new Solution();

    public static void main(String[] args) {
        int arr[] = {3, 30, 34, 5, 9};
        System.out.println(solution.solution(arr));
    }

    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            int size = numbers.length;

            for (int i = 0; i < size - 1; i++) {
                for (int j = i; j < size; j++) {
                    if (numbers[i] > numbers[j]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                    }
                }
            }

            Arrays.toString(numbers);

            return answer;
        }
    }
}
