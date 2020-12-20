package org.exemple.lesson2.ex2_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(4);
        elements.add(15);
        elements.add(3);
        elements.add(2);
        elements.add(8);
        int input = 5;

        final Set<Integer> seen = new HashSet<>();
        for (int element : elements) {
            if (seen.contains(input - element)) {
                System.out.println("{" + (elements.indexOf(input - element)) + "," + elements.indexOf(element) + "}");
            }
            seen.add(element);
        }
    }
}
