package ru.dinz.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class StartUI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };
    private static final java.util.List<List<Integer>> listList = new ArrayList<>();

    public static void main(String[] args) {
        listList.add(new SinglyLinkedList<>(comparator));
        boolean run = true;
        while (run) {
            System.out.println("0. создать лист");
            System.out.println("1. добавить");
            System.out.println("2. получить");
            System.out.println("3. удалить");
            System.out.println("4. вырезать часть списка");
            System.out.println("5. объединить два списка");
            System.out.println("6. размер");
            System.out.println("7. поделить");
            System.out.println("8. вывести весь список");
            System.out.println("9. выход");
            int select = askInt("Выбор: ");
            while (select < 0 || select > 9) {
                System.out.println("Ввод должен быть в диапазоне: 0 .. " + (9));
                select = askInt("Выбор: ");
            }
            try {
                switch (select) {
                    case 0 -> listList.add(new SinglyLinkedList<>(comparator));
                    case 1 -> getList().add(askInt("Введите число "));
                    case 2 -> getList().get(askInt("Введите индекс значения "));
                    case 3 -> getList().remove(askInt("Введите индекс значения "));
                    case 4 -> getList().subList(askInt("Введите индекс начального значения "), askInt("Введите индекс конечного значения "));
                    case 5 -> getList().addAll(getList());
                    case 6 -> getList().size();
                    case 7 -> listList.addAll(getList().division(askInt("Введите делитель ")));
                    case 8 -> getList().forEach(System.out::println);
                    case 9 -> run = false;
                }
            } catch (IndexOutOfBoundsException e) {
                //e.printStackTrace();
            }
        }
    }

    private static List<Integer> getList() {
        int index;
        do {
            index = askInt("Введите индекс списка ");
            if (listList.size() == 0) {
                throw new NoSuchElementException();
            }
        } while (listList.size() <= index);
        return listList.get(index);
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
