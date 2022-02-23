package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class EquationAction implements UserAction {

    private final Output out;

    public EquationAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Корни квадратного уравнения по заданным коэффициентам";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        return true;
    }
}
