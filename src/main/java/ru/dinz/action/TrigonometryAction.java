package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class TrigonometryAction implements UserAction {

    private final Output out;

    public TrigonometryAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Тригонометрические операции";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        boolean run = true;
        String question = input.askStr("sin, cos, tg, ctg? ");
        int degrees = input.askInt("Введите угол в градусах ");
        double radians = Math.toRadians(degrees);
        double answer = 0;
        while (run) {
            run = false;
            switch (question) {
                case "sin" -> answer = Math.sin(radians);
                case "cos" -> answer = Math.cos(radians);
                case "tg" -> answer = Math.tan(radians);
                case "ctg" -> answer = 1 / Math.tan(radians);
                default -> {
                    question = input.askStr("sin, cos, tg, ctg? ");
                    run = true;
                }
            }
        }
        if (answer > 5443746451065122L) {
            out.println("Не существует");
        } else {
            out.println(String.format("%.4f", answer));
        }
        return true;
    }
}
