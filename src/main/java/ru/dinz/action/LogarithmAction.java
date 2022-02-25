package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class LogarithmAction implements UserAction {

    private final Output out;

    public LogarithmAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Натуральный логарифм";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        int num = input.askInt("Введите число ");
        out.println(Math.log(num));
        return true;
    }
}
