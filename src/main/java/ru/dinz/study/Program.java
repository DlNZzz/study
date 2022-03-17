package ru.dinz.study;

import ru.dinz.*;
import ru.dinz.study.factory.ColumnSortFactory;
import ru.dinz.study.factory.LineSortFactory;
import ru.dinz.study.factory.SortFactory;

import java.util.ArrayList;
import java.util.List;

public class Program {

    private Output out;

    public Program() {
        this.out = new ConsoleOutput();
    }

    public Program(Output out) {
        this.out = out;
    }

    public void init(Input input, Memory mem, List<SortFactory> listAction) {
        boolean run = true;
        mem.init(initArrayGenerate(input));
        while (run) {
            out.println("0. Удалить и создать новый масив.");
            out.println("1. Оставить.");
            int select = input.askInt("Выбор: ");
            while (select < 0 || select >= 2) {
                out.println("Ввод должен быть в диапазоне: 0 .. " + (1));
                select = input.askInt("Выбор: ");
            }
            if (select == 0) {
                mem.init(initArrayGenerate(input));
            }
            this.showMenu(listAction);
            select = input.askInt("Выбор: ");
            while (select < 0 || select >= listAction.size()) {
                out.println("Ввод должен быть в диапазоне: 0 .. " + (listAction.size() - 1));
                select = input.askInt("Выбор: ");
            }
            SortFactory factories = listAction.get(select);
            for (Sort s : Sort.values()) {
                out.println(s.getNum() + ". " + s.getName());
            }
            select = input.askInt("Выбор: ");
            while (select < 0 || select >= Sort.values().length) {
                out.println("Ввод должен быть в диапазоне: 0 .. " + (Sort.values().length - 1));
                select = input.askInt("Выбор: ");
            }
            switch (Sort.values()[select]) {
                case BUBBLE -> factories.createBubbleSort().execute(input, mem);
                case INSERTION -> factories.createInsertionSort().execute(input, mem);
                case MERGE -> factories.createMergeSort().execute(input, mem);
                case QUICK -> factories.createQuickSort().execute(input, mem);
                case EXIT -> run = false;
            }
            print(mem, input);
        }
    }

    private void print(Memory memory, Input input) {
        out.println("0. Вывести весь массив.");
        out.println("1. Отдельный элемент.");
        int select = input.askInt("Выбор: ");
        while (select < 0 || select >= 2) {
            out.println("Ввод должен быть в диапазоне: 0 .. " + (1));
            select = input.askInt("Выбор: ");
        }
        List<List<Integer>> lists = memory.getList();
        if (select == 0) {
            for (List<Integer> list : lists) {
                for (Integer num : list) {
                    out.print(num + " ");
                }
                out.println("");
            }
        } else {
            int line = input.askInt("Введите строку: ");
            while (line < 0 || line >= lists.get(0).size()) {
                line = input.askInt("Введите строку в пределах массива: ");
            }
            int columns = input.askInt("Введите столбец: ");
            while (columns < 0 || columns >= lists.size()) {
                columns = input.askInt("Введите столбец в пределах массива: ");
            }
            out.println(lists.get(line).get(columns));
        }
    }

    private void showMenu(List<SortFactory> listAction) {
        out.println("Сортировка.");
        for (int index = 0; index < listAction.size(); index++) {
            out.println(index + ". " + listAction.get(index).getName());
        }
    }

    private static List<List<Integer>> initArrayGenerate(Input input) {
        int line = input.askInt("Введите line: ");
        int column = input.askInt("Введите column: ");
        int from = input.askInt("Введите диапазон чисел от: ");
        int to = input.askInt("Введите до: ");
        List<List<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < line; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i < line; i++) {
            List<Integer> list = arrayList.get(i);
            for (int j = 0; j < column; j++) {
                list.add(randomInt(from, to));
            }
        }
        return arrayList;
    }

    private static int randomInt(int from, int to) {
        return (int) (Math.random() * (to - from)) + from;
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(
                new ConsoleOutput(),
                new ConsoleInput()
        );
        Output output = new ConsoleOutput();
        Memory memory = new ArrayMemory();
        memory.init();
        List<SortFactory> factories = List.of(
                new LineSortFactory(output),
                new ColumnSortFactory(output)
        );
        new Program().init(input, memory, factories);
    }
}
//