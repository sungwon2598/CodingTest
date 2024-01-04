package com.example.bj1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i++) {
            String input[] = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            BigInteger nFact = factorial(n);
            BigInteger nMmFact = factorial(n - m);
            BigInteger mFact = factorial(m);
            BigInteger result = nFact.divide(nMmFact.multiply(mFact));
            System.out.println(result);
        }
    }

    public static BigInteger factorial(int n) {
        BigInteger k = BigInteger.valueOf(n);
        BigInteger gob = BigInteger.valueOf(1);
        while (k.compareTo(BigInteger.ONE) > 0) {
            gob = gob.multiply(k);
            k = k.subtract(BigInteger.ONE);
        }
        return gob;
    }
}
