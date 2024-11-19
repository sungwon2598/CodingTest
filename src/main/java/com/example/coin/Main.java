package com.example.coin;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
    }

    private static void abc(int coins[], int target, ArrayList<Integer> hap, int index) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            printCoins(hap);
        } else {
            for (int i = index; i < coins.length; i++) {
                if (target - coins[i] >= 0) {
                    hap.add(coins[i]);
                    abc(coins, target - coins[i], hap, i);
                    hap.remove(hap.size() - 1);
                }
            }
        }
    }

    private static void printCoins(ArrayList<Integer> hap) {

    }
}
