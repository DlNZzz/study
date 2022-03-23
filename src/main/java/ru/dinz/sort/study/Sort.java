package ru.dinz.sort.study;

public enum Sort {

    BUBBLE(0,"Сортировка пузырьком."),
    INSERTION(1,"Сортировка вставками."),
    MERGE(2,"Сортировка слиянием."),
    QUICK(3,"Быстрая сортировка."),
    EXIT(4, "Выход.");

    private int num;
    private String name;

    Sort(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
