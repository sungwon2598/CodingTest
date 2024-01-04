package com.example.bj10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[101];
        arr[1] = new BigInteger("9");
        BigInteger n = BigInteger.ONE;
        for (int i = 2; i <= 100; i++) {
            arr[i] = arr[i - 1].multiply(BigInteger.valueOf(2)).subtract(n);
            n = n.add(BigInteger.ONE);
        }
        BigInteger modulus = BigInteger.valueOf(1000000000);
        System.out.println(arr[num].mod(modulus));
    }
}
