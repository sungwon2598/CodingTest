package com.example.bj1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        String input[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            System.out.print("현재 위치로 끝나는 부분 배열 최대합 : " + maxEndingHere + "  ");
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            System.out.println("지금까지 최대합 : " + maxSoFar);
        }

        return maxSoFar;
    }
}
