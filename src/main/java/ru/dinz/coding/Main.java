package ru.dinz.coding;

import ru.dinz.coding.utils.CodeDecode;
import ru.dinz.coding.utils.Mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        List<CodeDecode> list = List.of(
                new Caesar(),
                new PlayFair(),
                new Vernama(),
                new Vijiner()
        );
        while (true) {
            System.out.println("0. Цезарь");
            System.out.println("1. Плейфера");
            System.out.println("2. Вернама");
            System.out.println("3. Вижинер");
            System.out.println("4. Выход");
            int select = askInt("Выбор: ");
            while (select < 0 || select > 4) {
                System.out.println("Ввод должен быть в диапазоне: 0 .. " + (4));
                select = askInt("Выбор: ");
            }
            if (select == 4) {
                return;
            } else {
                System.out.println("0. Шифрование");
                System.out.println("1. Дешифрование");
                int selectShifr = askInt("Выбор: ");
                while (select < 0 || select > 1) {
                    System.out.println("Ввод должен быть в диапазоне: 0 .. " + (1));
                    select = askInt("Выбор: ");
                }
                if (selectShifr == 0) {
                    System.out.println("0. Мануальный");
                    System.out.println("1. Автоматический");
                    System.out.println("2. Другой");
                    int selectMode = askInt("Выбор: ");
                    while (select < 0 || select > 2) {
                        System.out.println("Ввод должен быть в диапазоне: 0 .. " + (2));
                        select = askInt("Выбор: ");
                    }
                    list.get(select).encryption(Mode.values()[selectMode]);
                } else {
                    list.get(select).decryption();
                }
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
