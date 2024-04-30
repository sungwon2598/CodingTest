package com.example.kyajava;

public class one {
    private int count = 0;
    private final int max;

    public one(int max) {
        this.max = max;
    }

    public void incremaent() {
        if (count + 1 < max) {
            count++;
        } else {
            System.out.println("최대값을 못넘음");
        }
    }

    public int getCount() {
        return count;
    }

}
