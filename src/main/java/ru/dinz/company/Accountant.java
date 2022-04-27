package ru.dinz.company;

public class Accountant extends Employee {

    public Accountant(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println("Бухгалтер работает.");
    }
}
