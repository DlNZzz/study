package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class FactorialAction implements UserAction {

    private final Output out;

    public FactorialAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Факториал";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        int num = input.askInt("Введите натуральное число ");
        boolean run = true;
        int answer = 1;
        while (run) {
            if (num >= 0) {
                run = false;
            } else {
                num = input.askInt("Введите натуральное число ");
            }
        }
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }
        out.println(answer);
        return true;
    }
}
