package ru.dinz.company;

public class Programmer extends Employee {

    public Programmer(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println("Программист работает.");
    }
}
