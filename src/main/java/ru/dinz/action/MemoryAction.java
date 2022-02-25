package ru.dinz.action;

import ru.dinz.Input;
import ru.dinz.Memory;
import ru.dinz.Output;
import ru.dinz.UserAction;

public class MemoryAction implements UserAction {

    private final Output out;

    public MemoryAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Сохранить введённое значение в одну из четырёх\n" +
                "ячеек памяти";
    }

    @Override
    public boolean execute(Input input, Memory mem) {
        double s = input.askDouble("Введите число которое хотитете сохранить ", mem);
        String askMem;
        String[] arrayMem;
        do {
            askMem = input.askStr("Введите ячейку mem1, mem2, mem3, mem4 ");
            arrayMem = askMem.split("mem");
            while (arrayMem.length != 2) {
                askMem = input.askStr("Введите ячейку mem1, mem2, mem3, mem4 ");
                arrayMem = askMem.split("mem");
            }
        } while (!mem.add(Integer.parseInt(arrayMem[1]) - 1, s));
        return true;
    }
}
