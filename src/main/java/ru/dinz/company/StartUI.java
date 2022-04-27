package ru.dinz.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartUI {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Map<Integer, Employee> data = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<Employee> employees = List.of(
                new Accountant("Бухгалтер"),
                new Programmer("Программист"),
                new Engineer("Инженер")
        );
        boolean run = true;
        while (run) {
            System.out.println("0. добавить");
            System.out.println("1. информация о сотруднике");
            System.out.println("2. уволить");
            System.out.println("3. выполнение работы");
            System.out.println("4. выход");
            int select = askInt("Выбор: ");
            while (select < 0 || select > 4) {
                System.out.println("Ввод должен быть в диапазоне: 0 .. " + (4));
                select = askInt("Выбор: ");
            }
            switch (select) {
                case 0 -> {
                    int id = askInt("Введите id ");
                    System.out.print("Введите имя ");
                    String name = reader.readLine();
                    System.out.print("Введите должность ");
                    String post = reader.readLine();
                    for (int index = 0; index < employees.size(); index++) {
                        System.out.println(index + ". " + employees.get(index).getName());
                    }
                    int selectEmployee = askInt("Введите сотрудника ");
                    while (selectEmployee < 0 || selectEmployee > 3) {
                        System.out.println("Ввод должен быть в диапазоне: 0 .. " + (employees.size() - 1));
                        selectEmployee = askInt("Выбор: ");
                    }
                    Employee employee = employees.get(selectEmployee);
                    Employee.ID employeeId = employee.new ID(id, name, post);
                    employee.setId(employeeId);
                    data.put(id, employee);
                }
                case 1 -> {
                    int id = askInt("Введите id ");
                    Employee employee = data.get(id);
                    if (employee == null) {
                        System.out.println("Сотрудник не найден");
                    } else {
                        System.out.println(data.get(id));
                    }
                }
                case 2 -> {
                    int id = askInt("Введите id ");
                    Employee isTrue = data.remove(id);
                    if (isTrue == null) {
                        System.out.println("Сотрудник не найден");
                    } else {
                        System.out.println("Сотрудник удален");
                    }
                }
                case 3 -> {
                    int id = askInt("Введите id ");
                    if (data.containsKey(id)) {
                        data.get(id).work();
                    } else {
                        System.out.println("Сотрудник не найден");
                    }
                }
                case 4 -> run = false;
            }
        }
    }

    public static int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                System.out.print(question);
                value = Integer.parseInt(reader.readLine());
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Введите число.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (invalid);
        return value;
    }
}
