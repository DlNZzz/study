package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class ConversionAction implements UserAction {

    private final Output out;

    public ConversionAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Конвертация числа из заданной \n" +
                "системы счисления в другую";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        String num = input.askStr("Введите цифру ");
        int numTwo = input.askInt("Введите основание ");
        int numThree = input.askInt("Введите новую систему счисления ");
        int nsTen = Integer.parseInt(num, numTwo);
        StringBuilder str = new StringBuilder();
        while (nsTen > 0) {
            int res = nsTen % numThree;
            if (res >= 10) {
                res += 55;
                str.insert(0, ((char) res));
            } else {
                str.insert(0, (res));
            }
            nsTen = nsTen / numThree;
        }
        out.println(str);
        return true;
    }
}
