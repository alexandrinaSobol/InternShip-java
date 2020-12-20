package org.exemple.lesson2.ex2_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final Set<Integer> set1 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(15);
        list.add(3);
        list.add(15);
        list.add(1);
        list.add(2);

        for (Integer integer : list) {
            if (!set1.add(integer)) {
                set1.remove(integer);
            }
        }
        System.out.println(set1);
    }
}
