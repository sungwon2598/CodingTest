package com.example.bj1018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(); //높이
        int w = sc.nextInt(); //너비
        String[][] arr = new String[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = sc.nextLine();
            }
        }

        ArrayList<Integer> size = new ArrayList<Integer>();
        //케이스별 다시 칠해야 하는 수

        int a = 0; //시작점 x(k)
        int b = 0; //시작점 y(i)
        while (b + 8 < h) {
            while (a + 8 < w) {
                if (arr[b][a].equals("W")) {
                    int cs = 0;
                    for (int i = b; i < b + 8; i++) {
                        for (int k = a; k < a + 8; k++) {
                            if (i % 2 != 0 && k % 2 != 0) {
                                if (!arr[i][k].equals("W")) {
                                    cs++;
                                }
                            } else if (i % 2 != 0 && k % 2 == 0) {
                                if (!arr[i][k].equals("B")) {
                                    cs++;
                                }
                            } else if (i % 2 == 0 && k % 2 != 0) {
                                if (!arr[i][k].equals("B")) {
                                    cs++;
                                }
                            } else if (i % 2 == 0 && k % 2 == 0) {
                                if (!arr[i][k].equals("W")) {
                                    cs++;
                                }
                            }
                        }
                    }
                    System.out.println(cs);
                    size.add(cs); //B로 시작할 때의 경우의 수 입력
                } else {
                    int cs = 0;
                    for (int i = b; i < b + 8; i++) {
                        for (int k = a; k < a + 8; k++) {
                            if (i % 2 != 0 && k % 2 != 0) {
                                if (!arr[i][k].equals("B")) {
                                    cs++;
                                }
                            } else if (i % 2 != 0 && k % 2 == 0) {
                                if (!arr[i][k].equals("W")) {
                                    cs++;
                                }
                            } else if (i % 2 == 0 && k % 2 != 0) {
                                if (!arr[i][k].equals("W")) {
                                    cs++;
                                }
                            } else if (i % 2 == 0 && k % 2 == 0) {
                                if (!arr[i][k].equals("B")) {
                                    cs++;
                                }
                            }
                        }
                    }
                    System.out.println(cs);
                    size.add(cs);
                }
                a++;
            }
            b++;
        }
        Collections.sort(size);
        for (int i = 0; i < size.size(); i++) {
            System.out.println(size.get(i));
        }
    }
}

