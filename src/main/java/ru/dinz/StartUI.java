package ru.dinz;

import ru.dinz.action.*;

import java.util.List;

public class StartUI {
    private Output out;

    public StartUI() {
        this.out = new ConsoleOutput();
    }

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Memory mem, List<UserAction> listAction) {
        boolean run = true;
        while (run) {
            this.showMenu(listAction);
            int select = input.askInt("Выбор: ");
            if (select < 0 || select >= listAction.size()) {
                out.println("Ввод должен быть в диапазоне: 0 .. " + (listAction.size() - 1));
                continue;
            }
            UserAction action = listAction.get(select);
            run = action.execute(input, mem);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showMenu(List<UserAction> listAction) {
        out.println("Калькулятор.");
        for (int index = 0; index < listAction.size(); index++) {
            out.println(index + ". " + listAction.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(
                new ConsoleOutput(),
                new ConsoleInput()
        );
        Output output = new ConsoleOutput();
        Memory calculator = new MemoryCalculator();
        calculator.init();
        List<UserAction> actions = List.of(
                new ArithmeticAction(output),
                new TrigonometryAction(output),
                new LogicalAction(output),
                new DegreeAction(output),
                new FactorialAction(output),
                new LogarithmAction(output),
                new NOCDEAction(output),
                new ConversionAction(output),
                new SquareAction(output),
                new EquationAction(output),
                new RandomAction(output),
                new MemoryAction(output),
                new ExitAction()
        );
        new StartUI().init(input, calculator, actions);
    }
}
