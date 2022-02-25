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
        int a, b, c;
        a = input.askInt("Введите первое число ");
        b = input.askInt("Введите второе число ");
        c = input.askInt("Введите третье число ");
        if (a == 0) {
            if (b != 0) {
                out.println("x1 = " + (-c / b));
            } else {
                out.println("корней нет");
            }
        } else {
            int d = b * b - 4 * a * c;
            if (d < 0) {
                out.println("корней нет");
            } else {
                double x1, x2;
                x1 = (-b + Math.sqrt(d)) / (2 * a);
                if (d == 0) {
                    out.println("Корни одинаковые x1 = " + x1);
                } else {
                    x2 = (-b - Math.sqrt(d)) / (2 * a);
                    out.println("x1 = " + x1 + "\nx2 = " + x2);
                }
            }
        }
        return true;
    }
}
