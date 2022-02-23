package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class SquareAction implements UserAction {

    private final Output out;

    public SquareAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Площадь правильного n-угольника по заданной стороне";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        return true;
    }
}
