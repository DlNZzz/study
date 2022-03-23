package ru.dinz.queue;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return compare(o1, o2);
            }
        });
        System.out.println(queue.add(123));
        System.out.println(queue.add(123));
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.remove(123));
        System.out.println(queue.peek());
        System.out.println(queue.contains(100));
    }
}
