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
        int n = input.askInt("Введите кол-во сторон ");
        int a = input.askInt("Введите длину стороны ");
        double square = 0;
        while (n <= 0 || a <= 0) {
            if (n <= 0) {
                n = input.askInt("Введите кол-во сторон ");
            }
            if (a <= 0) {
                a = input.askInt("Введите длину стороны ");
            }
        }
        square = (n * Math.pow(a, 2)) / (4 * Math.tan(Math.toRadians((double) 180 / n)));
        if (square % 1 > 0.999999) {
            square = (int) square + 1;
        }
        out.println(square);
        return true;
    }
}
