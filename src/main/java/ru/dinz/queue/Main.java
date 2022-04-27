package ru.dinz.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Heap<Integer> queue = new Heap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare(Integer.parseInt(o1.toString()), Integer.parseInt(o2.toString()));
            }
        });
        boolean run = true;
        while (run) {
            System.out.println("0. добавить");
            System.out.println("1. найти");
            System.out.println("2. удалить");
            System.out.println("3. выход");
            int select = askInt("Выбор: ");
            while (select < 0 || select > 3) {
                System.out.println("Ввод должен быть в диапазоне: 0 .. " + (2));
                select = askInt("Выбор: ");
            }
            switch (select) {
                case 0 -> queue.add(askInt("Введитье число "));
                case 1 -> System.out.println(queue.contains(askInt("Введитье число ")));
                case 2 -> queue.remove(askInt("Введитье число "));
                case 3 -> run = false;
            }
        }
    }

    public static int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                System.out.print(question);
                value = Integer.parseInt(reader.readLine());
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Введите число.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (invalid);
        return value;
    }
}
