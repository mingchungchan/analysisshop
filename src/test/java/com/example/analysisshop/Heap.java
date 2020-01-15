package com.example.analysisshop;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        for (; ; ) {
            System.out.println(i);
            list.add(String.valueOf(i++).intern());
        }
    }
}
