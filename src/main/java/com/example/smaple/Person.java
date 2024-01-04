package com.example.smaple;


import java.util.Scanner;

public class Person {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + 100 + (int)(Math.random() * 201));
        }
    }

}








