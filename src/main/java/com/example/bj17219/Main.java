package com.example.bj17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> site = new HashMap<>();
        ArrayList<String> siteName = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringTokenizer st = new StringTokenizer(n);
        String n1 = st.nextToken();
        String n2 = st.nextToken();

        for (int i = 0; i < Integer.parseInt(n1); i++) {
            String n3 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(n3);
            String n31 = st2.nextToken();
            String n32 = st2.nextToken();
            site.put(n31, n32);
        }

        for (int i = 0; i < Integer.parseInt(n2); i++) {
            siteName.add(br.readLine());
        }

        for (int i = 0; i < Integer.parseInt(n2); i++) {
            System.out.println(site.get(siteName.get(i)));
        }
    }
}
