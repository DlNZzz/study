package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class NOCDEAction implements UserAction {

    private final Output out;

    public NOCDEAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "НОК и НОД двух чисел";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        return true;
    }
}
