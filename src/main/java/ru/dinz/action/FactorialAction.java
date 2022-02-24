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

        return true;
    }
}
