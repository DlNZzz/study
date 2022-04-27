package ru.dinz.company;

public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println("Инженер работает.");
    }
}
