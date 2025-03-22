package com.minsu.example;

import java.util.*;

public class Main {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.solution());
    }

    public int solution() {
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            int num = scanner.nextInt();
            list.add(num);
        }
        int max1 = 0;
        int size = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                size++;
                max1 = Integer.max(max1, size);
                continue;
            }
            if (list.get(i) >= list.get(i - 1)) {
                size++;
                max1 = Integer.max(max1, size);
            } else {
                size = 1;
            }
        }

        int max2 = 0;
        size = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                size++;
                max1 = Integer.max(max1, size);
                continue;
            }
            if (list.get(i) <= list.get(i - 1)) {
                size++;
                max2 = Integer.max(max2, size);
            } else {
                size = 1;
            }
        }

        return Integer.max(max1, max2);
    }
}