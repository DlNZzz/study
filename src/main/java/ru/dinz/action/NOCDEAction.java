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
        int numOne = input.askInt("Введите первое число ");
        int numTwo = input.askInt("Введите второе число ");
        out.println(gcd(numOne, numTwo));
        out.println(lcm(numOne, numTwo));
        return true;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
