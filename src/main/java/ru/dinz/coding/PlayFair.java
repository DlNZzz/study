package ru.dinz.coding;

import ru.dinz.coding.utils.CodeDecode;
import ru.dinz.coding.utils.InputLines;
import ru.dinz.coding.utils.Mode;

public class PlayFair implements CodeDecode {

    @Override
    public void encryption(Mode mode) {
        if (mode == Mode.MANUAL) {
            System.out.println("Ведите текст для шифровки");
            String text = InputLines.getText();
            System.out.println("Введите ключ шифровки");
            String key = InputLines.getText();
            if (text.length() != key.length()) {
            System.out.println("Текст для шифрования и ключ должны быть одной длины для лучшей криптостойкости");
            return;
        }
        enc(text, key);
    } else if (mode == Mode.AUTO) {
        System.out.println("Ведите текст для шифровки");
        String text = InputLines.getText();
        System.out.println("Введите ключ для шифровки");             String key = InputLines.autoCreateKey(text.length());
        if (text.length() != key.length()) {
            System.out.println("Текст для шифрования и ключ должны быть одной длины для лучшей криптостойкости");
            return;
        }
        enc(text, key);
    } else {
        System.out.println("Режим выбран не корректно!");
    }
    }

    public void enc(String text, String key) {
        // Инициализая поля для шифрования
        String cipherText = "";
        // Инициализировать шифрованный массив длины ключа
        //, в котором хранится сумма соответствующих номеров
        // открытого текста и ключа.
        int cipher[] = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            cipher[i] = text.charAt(i) - 'a'
                + key.charAt(i)
                - 'a';
        }
        // Если сумма больше 25
        // вычтите из него 26
        // и сохранить это результирующее значение
        for (int i = 0; i < key.length(); i++) {
            if (cipher[i] > 25) {
                cipher[i] = cipher[i] - 26;
            }
        }
// Преобразование номера в целые числа
// Преобразуйте эти целые числа в соответствующие         // символов и добавьте их в зашифрованный текст
        for (int i = 0; i < key.length(); i++) {
            int x = cipher[i] + 'a';
            cipherText += (char)x;
        }
                System.out.printf("""
                Сообщение для зашифровки %s
                Ключ для зашифровки %s
                Защифрованное сообщение %s
                """, text, key, cipherText);
                }

    @Override
    public void decryption() {
        String text = InputLines.getText();
        String key = InputLines.getText();
        if (text.length() != key.length()) {
            System.out.println("Зашифрованный текст и ключ должны быть одной длины");
            return;
        }
        //Инициализая поля в которое будет записан расшифрован текст
        String plainText = "";
        // Инициализация целочисленного массива длины ключа
        // который хранит разницу
        // соответствующего номера'текста
        // каждого символа зашифрованного текста и ключа
        int plain[] = new int[key.length()];
        // Выполнение цикла for для каждого символа         // вычитание и сохранение в массиве
        for (int i = 0; i < key.length(); i++) {
            plain[i] = text.charAt(i) - 'a' - (key.charAt(i) - 'a');
        }
        // Если разница меньше 0
        // добавьте 26 и сохраните его в массиве.
        for (int i = 0; i < key.length(); i++) {
            if (plain[i] < 0) {
            plain[i] = plain[i] + 26;
            }
        }
        // Преобразование int в соответствующий символ
        // добавьте их в обычный текст
        for (int i = 0; i < key.length(); i++) {
            int x = plain[i] + 'a';
            plainText += (char)x;
        }
        System.out.printf("""
                Сообщение для расшифровки %s
                Ключ для расшифровки %s
                Расшифрованное сообщение %s
                """, text, key, plainText);
    }
}
