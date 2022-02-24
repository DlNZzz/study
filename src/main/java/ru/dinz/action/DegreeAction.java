package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class DegreeAction implements UserAction {

    private final Output out;

    public DegreeAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Степень числа";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        int num = input.askInt("Введите число ");
        int degree = input.askInt("Введите степень ");
        out.println(Math.pow(num, degree));
        return true;
    }
}
