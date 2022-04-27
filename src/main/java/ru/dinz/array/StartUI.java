package ru.dinz.array;

import java.util.Comparator;
import java.util.LinkedList;

public class StartUI {
    public static void main(String[] args) {
        List<Integer> list = new SinglyLinkedList<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        list.add(123);
        list.add(2);
        list.add(-324);
        list.add(3232);
        list.add(-2222);
        list.forEach(System.out::println);
        System.out.println();
        LinkedList<Integer> s = new LinkedList<Integer>();
        list.subList(1, 4);
        list.forEach(System.out::println);
    }
}
